package com.airbnb.Service;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.airbnb.DTO.LocationDTO;
import com.airbnb.Exception.LocationNotFoundException;
import com.airbnb.Model.Location;
import com.airbnb.Repository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {

	
	@Autowired
	private LocationRepository locationRepository;
	@Autowired 
	private ModelMapper modelMapper;

	@Override
	public LocationDTO enterLocation(LocationDTO locationDTO) throws LocationNotFoundException {
		// TODO Auto-generated method stub
		 Location location = modelMapper.map(locationDTO, Location.class);
		 Location savedLocation = locationRepository.save(location);
		 return modelMapper.map(savedLocation, LocationDTO.class);
	}

	@Override
	public String deleteLocation(Integer locationID) throws LocationNotFoundException {
		Location location=locationRepository.findById(locationID).orElseThrow(()->new LocationNotFoundException("No location is present with this id- "+locationID));
		locationRepository.delete(location);
		return "Location deleted successfully..";
	}

	@Override
	public LocationDTO getLocationById(Integer locationId) throws LocationNotFoundException {
		Location location=locationRepository.findById(locationId).orElseThrow(()->new LocationNotFoundException("No location is present with this id- "+locationId));
		
		return modelMapper.map(location, LocationDTO.class);
	}

	@Override
	public List<LocationDTO> getAllLocation() throws LocationNotFoundException {
		List<Location> location=locationRepository.findAll();
		List<LocationDTO>list=location.stream().map((map)->modelMapper.map(map, LocationDTO.class)).collect(Collectors.toList());
		return list;
	}

	@Override
	public LocationDTO updateLocationDto(Integer locationId, LocationDTO locationDTO) throws LocationNotFoundException {
		Location location=locationRepository.findById(locationId).orElseThrow(()->new LocationNotFoundException("No location is present with this id- "+locationId));
		location.setAddress(locationDTO.getAddress());
		location.setCity(locationDTO.getCity());
		location.setCountry(locationDTO.getCountry());
		location.setPincode(locationDTO.getPincode());
		location.setCountry(locationDTO.getCountry());
		
		Location result= locationRepository.save(location);
		return modelMapper.map(result, locationDTO.getClass());
	}
	
	 
}
