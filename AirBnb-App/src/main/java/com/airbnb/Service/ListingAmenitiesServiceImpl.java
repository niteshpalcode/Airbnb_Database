package com.airbnb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airbnb.Exception.AmenitiesNotFoundException;
import com.airbnb.Exception.ListingAmenitiesException;
import com.airbnb.Exception.ListingNotFoundException;
import com.airbnb.Model.Amenities;
import com.airbnb.Model.Listing;
import com.airbnb.Model.ListingAmenities;
import com.airbnb.Repository.AmenitesRepository;
import com.airbnb.Repository.ListingAmenitiesRepository;
import com.airbnb.Repository.ListingRepository;

@Service
public class ListingAmenitiesServiceImpl implements ListingAmenitiesService {

	@Autowired 
	private AmenitesRepository amenitesRepository;
	@Autowired 
	private ListingAmenitiesRepository listingAmenitiesRepository;
	@Autowired 
	private ListingRepository listingRepository;
	
	
	
	
	@Override
	public String assignListingAmenities(Integer listingId, Integer amenitiesId)
			throws AmenitiesNotFoundException, ListingNotFoundException {
		
		Listing listing=listingRepository.findById(listingId).orElseThrow(()->new ListingNotFoundException("No Listing is present"));
		Amenities amenities=amenitesRepository.findById(amenitiesId).orElseThrow(()->new AmenitiesNotFoundException("No amenities found.."));
		
		ListingAmenities listingAmenities=new ListingAmenities();
		listingAmenities.setAmenities(amenities);
		listingAmenities.setListing(listing);
		listingAmenitiesRepository.save(listingAmenities);
		return "Assigned Listing-> "+listingId+ " to amenities with-> "+ amenitiesId;
	}




	@Override
	public String deleteListingAmenities(Integer listingAmenityId) throws ListingAmenitiesException {
		ListingAmenities listingAmenities=listingAmenitiesRepository.findById(listingAmenityId)
											.orElseThrow(()->new ListingAmenitiesException("Not present with this id"));
		listingAmenities.setAmenities(null);
		listingAmenities.setListing(null);
		listingAmenitiesRepository.delete(listingAmenities);
		
		return "Successfully deleted......";
	}

	
}
