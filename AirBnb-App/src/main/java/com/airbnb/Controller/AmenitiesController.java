package com.airbnb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airbnb.DTO.AmenitiesDTO;
import com.airbnb.Exception.AmenitiesNotFoundException;
import com.airbnb.Model.Amenities;
import com.airbnb.Service.AmenitiesService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/amenities")
public class AmenitiesController {

	
	@Autowired
	private AmenitiesService amenitiesService;
	
	@PostMapping("/add")
	public ResponseEntity<AmenitiesDTO> addNewAmenityHandler(@RequestBody AmenitiesDTO amenitiesDTO) throws AmenitiesNotFoundException{
		return new ResponseEntity<AmenitiesDTO>(amenitiesService.addAmenities(amenitiesDTO),HttpStatus.CREATED);
	}
	@GetMapping("/view/amenityId/{id}")
	public ResponseEntity<AmenitiesDTO> getAmenityByIdHandler(@PathVariable("id")Integer id) throws AmenitiesNotFoundException{
		return new ResponseEntity<AmenitiesDTO>(amenitiesService.getByID(id),HttpStatus.OK);
	}
	@DeleteMapping("/delete/amenityId/{id}")
	public ResponseEntity<String> deleteAmenityByIdHandler(@PathVariable("id")Integer id) throws AmenitiesNotFoundException{
		return new ResponseEntity<String>(amenitiesService.deleteAmenities(id),HttpStatus.OK);
	}
	@GetMapping("/view/amenity")
	public ResponseEntity<List<AmenitiesDTO>> getAllAmenityHandler() throws AmenitiesNotFoundException{
		return new ResponseEntity<List<AmenitiesDTO>>(amenitiesService.getAllAmenities(),HttpStatus.OK);
	}
	@PutMapping("/update/amenityId/{id}")
	public ResponseEntity<AmenitiesDTO> updateAmenityHandler(@PathVariable("id")Integer id,@RequestBody AmenitiesDTO amenities) throws AmenitiesNotFoundException{
		return new ResponseEntity<AmenitiesDTO>(amenitiesService.updateAmenity(id, amenities),HttpStatus.CREATED);
	}
}
