package com.airbnb.Service;

import java.util.List;

import com.airbnb.DTO.ListingDTO;
import com.airbnb.Exception.ListingNotFoundException;
import com.airbnb.Exception.LocationNotFoundException;
import com.airbnb.Exception.UsersNotfoundException;
import com.airbnb.Model.ListingResponse;

public interface ListingService {

	public ListingDTO createListing(Integer userId, Integer locationId, ListingDTO listingDTO) 
			throws UsersNotfoundException,LocationNotFoundException,ListingNotFoundException;
	public String deleteListing(Integer userId,Integer listingId) throws UsersNotfoundException,ListingNotFoundException;
	
	public ListingDTO getListing(Integer listingId) throws ListingNotFoundException;
	
	public List<ListingDTO> getAllListingByUser(Integer userId) throws UsersNotfoundException,ListingNotFoundException;
	
	public ListingDTO updateListing(ListingDTO listingDTO,Integer listingId)throws ListingNotFoundException;
	
	public List<ListingDTO>  getAllListingDetails()throws ListingNotFoundException;
	
	public List<ListingDTO> searchByTitle(String keyword) throws ListingNotFoundException;
	
	public ListingResponse getAllListingByUser(Integer userId,Integer pageNo,Integer pageSize) throws UsersNotfoundException,ListingNotFoundException;
	
	public List<ListingDTO> searchByDescription(String key); 
	
//	sortby normal id---- accsending
	
}
