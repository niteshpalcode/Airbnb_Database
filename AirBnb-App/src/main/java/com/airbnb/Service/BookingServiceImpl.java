package com.airbnb.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.management.ListenerNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.airbnb.DTO.BookingDTO;
import com.airbnb.DTO.BookingObjDto;
import com.airbnb.DTO.ListingDTO;
import com.airbnb.DTO.ListingDTO1;
import com.airbnb.DTO.LocationDTO;
import com.airbnb.DTO.UserDTO1;
import com.airbnb.DTO.UsersDTO;
import com.airbnb.Enums.Status;
import com.airbnb.Exception.BookingNotFoundException;
import com.airbnb.Exception.ListingNotFoundException;
import com.airbnb.Exception.UsersNotfoundException;
import com.airbnb.Model.Bookings;
import com.airbnb.Model.Listing;

import com.airbnb.Model.Users;
import com.airbnb.Repository.BookingRepository;
import com.airbnb.Repository.ListingRepository;
import com.airbnb.Repository.UsersRepository;

@Service
public class BookingServiceImpl  implements BookingService{
	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private ListingRepository listingRepository;
	@Autowired 
	private ModelMapper modelMapper;
	
	
	
	@Override
	public BookingDTO createBookingByUser(Integer userId, Integer listingId, BookingDTO bookingDTO)
			throws BookingNotFoundException, UsersNotfoundException, ListingNotFoundException {
		Users users=usersRepository.findById(userId).orElseThrow(()->new UsersNotfoundException("No user is present with this id- "+userId));
		
		Listing list=listingRepository.findById(listingId).orElseThrow(()->new ListingNotFoundException("No listing is found.."));
		
		Bookings bookings=modelMapper.map(bookingDTO, Bookings.class);
		bookings.setUsers(users);
		bookings.setListing(list);
		bookings.setCheckIn(LocalDate.now());
		bookings.setCheckOut(LocalDate.now());
		
//		bookings.setStatus(Status.values());
//		Status status = Status.PENDING;
		Bookings saved= bookingRepository.save(bookings);
		
		
		BookingDTO savedto= modelMapper.map(saved, BookingDTO.class);
		savedto.setUsersDTO(modelMapper.map(users, UserDTO1.class));
		LocationDTO ldto= modelMapper.map(list.getLocation(), LocationDTO.class); 
		
			ListingDTO1 ldto1=	modelMapper.map(list, ListingDTO1.class);
			ldto1.setLocationDTO(ldto);
	
			savedto.setListingDTO(ldto1);
			
		
		return savedto;
	}
	@Override
	public String deleteBooking(Integer userId, Integer bookingId)
			throws UsersNotfoundException, BookingNotFoundException {
		Users users=usersRepository.findById(userId).orElseThrow(()->new UsersNotfoundException("No user is present with this id- "+userId));
		Bookings bookings=bookingRepository.findById(bookingId).orElseThrow(()->new BookingNotFoundException("No booking is there"));
		if(bookings.getUsers().getUserid()==userId) {
			bookings.setListing(null);

			bookings.setUsers(null);
			bookingRepository.delete(bookings);
			
		}
		return "DELETD!!!";
	}
	@Override
	public BookingDTO getBookingById(Integer bookingId) throws BookingNotFoundException {
		  Bookings bookings = bookingRepository.findById(bookingId)
		            .orElseThrow(() -> new BookingNotFoundException("No booking is there"));

		    BookingDTO booking = modelMapper.map(bookings, BookingDTO.class);

		   
		    UserDTO1 userDTO = modelMapper.map(bookings.getUsers(), UserDTO1.class);
		    booking.setUsersDTO(userDTO);

		    
		    ListingDTO1 listingDTO = modelMapper.map(bookings.getListing(), ListingDTO1.class);

		  
		    LocationDTO locationDTO = modelMapper.map(bookings.getListing().getLocation(), LocationDTO.class);
		    listingDTO.setLocationDTO(locationDTO);

		    booking.setListingDTO(listingDTO);

		    return booking;
	}
	@Override
	public List<BookingDTO> getAllBooking() throws BookingNotFoundException {
		List<Bookings> bookings=bookingRepository.findAll();
		List<BookingDTO> list=bookings.stream().map((m)->{
			BookingDTO bt=modelMapper.map(m, BookingDTO.class);
			UserDTO1 ud1=modelMapper.map(m.getUsers(), UserDTO1.class);
			bt.setUsersDTO(ud1);
			ListingDTO1 ld1=modelMapper.map(m.getListing(), ListingDTO1.class);
			
			LocationDTO ld2=modelMapper.map(m.getListing().getLocation(), LocationDTO.class);
			ld1.setLocationDTO(ld2);
			bt.setListingDTO(ld1);
			return bt;
		}).collect(Collectors.toList());
		return list;
		
	}
	@Override
	public BookingObjDto updateBooking(Integer bookingId, BookingObjDto bookingObjDto) throws BookingNotFoundException {
		Bookings bookings=bookingRepository.findById(bookingId).orElseThrow(()->new BookingNotFoundException("No booking is there"));
		
		bookings.setCheckIn(LocalDate.now());
		bookings.setCheckOut(LocalDate.MAX);
		bookings.setTotalPrice(bookingObjDto.getTotalPrice());
		bookings.setStatus(bookingObjDto.getStatus());
		
	Bookings b=	bookingRepository.save(bookings);
		
		
		return modelMapper.map(b, BookingObjDto.class);
	}
	
	
}
