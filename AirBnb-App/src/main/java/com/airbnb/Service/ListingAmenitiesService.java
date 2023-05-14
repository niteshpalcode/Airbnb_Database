package com.airbnb.Service;

import com.airbnb.Exception.AmenitiesNotFoundException;
import com.airbnb.Exception.ListingAmenitiesException;
import com.airbnb.Exception.ListingNotFoundException;
import com.airbnb.Model.ListingAmenities;

public interface ListingAmenitiesService {

	
	public String assignListingAmenities(Integer listingId,Integer amenitiesId)throws
					AmenitiesNotFoundException,ListingNotFoundException;
	public String deleteListingAmenities(Integer listingAmenityId) throws ListingAmenitiesException;
	
	
	
}
