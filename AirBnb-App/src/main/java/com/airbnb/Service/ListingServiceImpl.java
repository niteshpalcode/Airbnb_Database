package com.airbnb.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.airbnb.DTO.ListingDTO;
import com.airbnb.DTO.LocationDTO;
import com.airbnb.DTO.UsersDTO;
import com.airbnb.Exception.ListingNotFoundException;
import com.airbnb.Exception.LocationNotFoundException;
import com.airbnb.Exception.UsersNotfoundException;
import com.airbnb.Model.Listing;
import com.airbnb.Model.ListingResponse;
import com.airbnb.Model.Location;
import com.airbnb.Model.Users;
import com.airbnb.Repository.ListingRepository;
import com.airbnb.Repository.LocationRepository;
import com.airbnb.Repository.UsersRepository;

@Service
public class ListingServiceImpl implements ListingService {

	@Autowired
	private ListingRepository listingRepository;
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private LocationRepository locationRepository;
	
	
	
	
	@Override
	public ListingDTO createListing(Integer userId, Integer locationId, ListingDTO listingDTO)
			throws UsersNotfoundException, LocationNotFoundException, ListingNotFoundException {
		Users user=usersRepository.findById(userId).orElseThrow(()->new UsersNotfoundException("No user is present"));
		Location location=locationRepository.findById(locationId).orElseThrow(()->
							new LocationNotFoundException("No location is present with this id"));
		
		Listing listing=modelMapper.map(listingDTO, Listing.class);
		
		listing.setUser(user);
		listing.setLocation(location);
		
		Listing savedListing=listingRepository.save(listing);
		
		ListingDTO listingdtos= modelMapper.map(savedListing, ListingDTO.class);
		
		listingDTO.setUsersDTO(modelMapper.map(user, UsersDTO.class));
		listingDTO.setLocationDTO(modelMapper.map(location, LocationDTO.class));
		
		return listingDTO;
		
		
		
		
		
	}

	@Override
	public String deleteListing(Integer userId, Integer listingId)
			throws UsersNotfoundException, ListingNotFoundException {
		Users user=usersRepository.findById(userId).orElseThrow(()->new UsersNotfoundException("No user is present"));
		Listing list=listingRepository.findById(listingId).orElseThrow(()->new ListingNotFoundException("No listing is found.."));
		list.setUser(null);
		list.setLocation(null);
		
		listingRepository.deleteById(listingId);
		
		return "Listing successFully deleted...";
	}

	@Override
	public ListingDTO getListing(Integer listingId) throws ListingNotFoundException {
		Listing list=listingRepository.findById(listingId).orElseThrow(()->new ListingNotFoundException("No listing is found.."));
		
		return modelMapper.map(list, ListingDTO.class);
	}

	@Override
	public List<ListingDTO> getAllListingByUser(Integer userId)
			throws UsersNotfoundException, ListingNotFoundException {
		Users user=usersRepository.findById(userId).orElseThrow(()->new UsersNotfoundException("No user is present"));
		List<Listing> list=listingRepository.findByUser(user);
		return list.stream().map((lists)->modelMapper.map(lists, ListingDTO.class)).collect(Collectors.toList());
	}

	@Override
	public ListingDTO updateListing(ListingDTO listingDTO, Integer listingId) throws ListingNotFoundException {
		Listing list=listingRepository.findById(listingId).orElseThrow(()->new ListingNotFoundException("No listing is found.."));
		list.setTitle(listingDTO.getTitle());
		list.setDescription(listingDTO.getDescription());
		list.setPrice(listingDTO.getPrice());
		list.setGuestLimits(listingDTO.getGuestLimits());
		
		Listing update= listingRepository.save(list);
		return modelMapper.map(update,ListingDTO.class);
	}

	@Override
	public List<ListingDTO> getAllListingDetails() throws ListingNotFoundException {
		List<Listing> list=listingRepository.findAll();
		
		return list.stream().map((lists)->modelMapper.map(lists, ListingDTO.class)).collect(Collectors.toList());
	}

	@Override
	public List<ListingDTO> searchByTitle(String keyword) throws ListingNotFoundException {
		List<Listing> list=listingRepository.findByTitleContainingIgnoreCase(keyword);
		if(list.size()==0) {
			throw new ListingNotFoundException("List is empty");
		}
		
		return list.stream().map((lists)->modelMapper.map(lists, ListingDTO.class)).collect(Collectors.toList());
	}

	@Override
	public ListingResponse getAllListingByUser(Integer userId, Integer pageNo, Integer pageSize)
			throws UsersNotfoundException, ListingNotFoundException {
		Users user=usersRepository.findById(userId).orElseThrow(()->new UsersNotfoundException("No user is present"));
		
		Pageable page=PageRequest.of(pageNo, pageSize);
		Page<Listing> pageList=listingRepository.findByUser(user, page);
		
		List<Listing> savedList=pageList.getContent();
		
		savedList.forEach(s->System.out.println(s.getTitle()));
		
		List<ListingDTO>lisingsdtos= savedList.stream().map(maps->{
			ListingDTO listingdtos=modelMapper.map(maps,ListingDTO.class);
			UsersDTO userDtos=modelMapper.map(maps.getUser(), UsersDTO.class);
			listingdtos.setUsersDTO(userDtos);
			LocationDTO locationDTOs=modelMapper.map(maps.getLocation(), LocationDTO.class);
			listingdtos.setLocationDTO(locationDTOs);
			return listingdtos;
		}).collect(Collectors.toList());
		
		ListingResponse listingResponse=new ListingResponse();
		listingResponse.setContent(lisingsdtos);
		listingResponse.setPageNo(pageList.getNumber());
		listingResponse.setPagesize(pageList.getSize());
		listingResponse.setTotalPage(pageList.getTotalPages());
		listingResponse.setLastpage(pageList.isLast());
		listingResponse.setTotalElement(pageList.getNumberOfElements());
		return listingResponse;
		
		
	}

	@Override
	public List<ListingDTO> searchByDescription(String key) {
		List<Listing> list=listingRepository.findByDescritption("%"+key+"%");
		List<ListingDTO>lisingsdtos= list.stream().map(maps->{
			ListingDTO listingdtos=modelMapper.map(maps,ListingDTO.class);
			UsersDTO userDtos=modelMapper.map(maps.getUser(), UsersDTO.class);
			listingdtos.setUsersDTO(userDtos);
			LocationDTO locationDTOs=modelMapper.map(maps.getLocation(), LocationDTO.class);
			listingdtos.setLocationDTO(locationDTOs);
			return listingdtos;
		}).collect(Collectors.toList());
		
		return lisingsdtos;
	}

	
}
