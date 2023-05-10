package com.airbnb.Service;

import java.util.List;

import com.airbnb.DTO.LocationDTO;
import com.airbnb.Exception.LocationNotFoundException;

public interface LocationService {

	
	public LocationDTO enterLocation(LocationDTO locationDTO) throws LocationNotFoundException;
	
	public String deleteLocation(Integer locationID)throws LocationNotFoundException;
	
	public LocationDTO getLocationById(Integer locationId) throws LocationNotFoundException;
	
	public List<LocationDTO> getAllLocation() throws LocationNotFoundException;
	
	public LocationDTO updateLocationDto(Integer locationId, LocationDTO locationDTO) throws LocationNotFoundException;
	
	
}
