package com.airbnb.Service;

import java.util.List;

import javax.management.ListenerNotFoundException;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.airbnb.DTO.BookingDTO;
import com.airbnb.DTO.BookingObjDto;
import com.airbnb.Exception.BookingNotFoundException;
import com.airbnb.Exception.ListingNotFoundException;
import com.airbnb.Exception.UsersNotfoundException;

public interface BookingService {

	public BookingDTO createBookingByUser(Integer userId, Integer listingId, BookingDTO bookingDTO ) throws BookingNotFoundException,
	UsersNotfoundException,ListingNotFoundException;
	public String deleteBooking(Integer userId, Integer bookingId) throws UsersNotfoundException,BookingNotFoundException;
	
	public BookingDTO getBookingById(Integer bookingId)throws BookingNotFoundException;
	
	public List<BookingDTO> getAllBooking()throws BookingNotFoundException;
	
	public BookingObjDto updateBooking(Integer bookingId,BookingObjDto bookingObjDto)throws BookingNotFoundException;
	 
	
}
