package com.airbnb.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airbnb.DTO.AmenitiesDTO;
import com.airbnb.Exception.AmenitiesNotFoundException;
import com.airbnb.Model.Amenities;
import com.airbnb.Repository.AmenitesRepository;

@Service
public class AmenitiesServiceImpl implements AmenitiesService {

	@Autowired
	private AmenitesRepository amenitesRepository;
	
	@Autowired 
	private ModelMapper modelMapper;

	@Override
	public AmenitiesDTO addAmenities(AmenitiesDTO amenitiesDTO) throws AmenitiesNotFoundException {
		Amenities amenities2=amenitesRepository.findByAmenityName(amenitiesDTO.getAmenityName());
		if(amenities2==null) {
			Amenities saved=modelMapper.map(amenitiesDTO, Amenities.class);
			Amenities am= amenitesRepository.save(saved);
			return  modelMapper.map(am,AmenitiesDTO.class);
		}
		throw new AmenitiesNotFoundException("Already present this amenity..");
	}

	@Override
	public String deleteAmenities(Integer id) throws AmenitiesNotFoundException {
		Amenities amenities=amenitesRepository.findById(id)
							.orElseThrow(()->new AmenitiesNotFoundException("No amenity is found"));
		amenitesRepository.delete(amenities);
		
		return "Successfully Deleted...";
	}

	@Override
	public AmenitiesDTO getByID(Integer id) throws AmenitiesNotFoundException {
		Amenities amenities=amenitesRepository.findById(id)
				.orElseThrow(()->new AmenitiesNotFoundException("No amenity is found"));
		
		return modelMapper.map(amenities,AmenitiesDTO.class);
	}

	@Override
	public List<AmenitiesDTO> getAllAmenities() {
		List<Amenities> amenities=amenitesRepository.findAll();
		return amenities.stream().map((m)->modelMapper.map(m,AmenitiesDTO.class )).collect(Collectors.toList());
		
	}

	@Override
	public AmenitiesDTO updateAmenity(Integer id, AmenitiesDTO amenitiesDTO) throws AmenitiesNotFoundException {
		Amenities amenities1=amenitesRepository.findById(id)
				.orElseThrow(()->new AmenitiesNotFoundException("No amenity is found"));
		amenities1.setAmenityName(amenitiesDTO.getAmenityName());
		Amenities saved=amenitesRepository.save(amenities1);
		return  modelMapper.map(saved,AmenitiesDTO.class);
	}
	
}
