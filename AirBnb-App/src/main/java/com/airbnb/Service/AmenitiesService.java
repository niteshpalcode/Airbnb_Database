package com.airbnb.Service;

import java.util.List;

import com.airbnb.DTO.AmenitiesDTO;
import com.airbnb.Exception.AmenitiesNotFoundException;
import com.airbnb.Model.Amenities;

public interface AmenitiesService {

	public AmenitiesDTO addAmenities(AmenitiesDTO amenitiesDTO) throws AmenitiesNotFoundException;
	
	public String deleteAmenities(Integer id) throws AmenitiesNotFoundException;
	
	public AmenitiesDTO getByID(Integer id) throws AmenitiesNotFoundException;
	
	public List<AmenitiesDTO> getAllAmenities();
	
	public AmenitiesDTO updateAmenity(Integer id, AmenitiesDTO amenitiesDTO) throws AmenitiesNotFoundException;
	
	
}
