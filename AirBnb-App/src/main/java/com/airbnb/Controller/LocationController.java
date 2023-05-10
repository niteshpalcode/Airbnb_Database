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

import com.airbnb.DTO.LocationDTO;
import com.airbnb.Exception.LocationNotFoundException;
import com.airbnb.Service.LocationService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/location")
public class LocationController {

	@Autowired
	private LocationService locationService;
	
	@PostMapping("/register")
	public ResponseEntity<LocationDTO> registerLocationHandler(@RequestBody LocationDTO locationDTO) throws LocationNotFoundException{
		return new ResponseEntity<LocationDTO>(locationService.enterLocation(locationDTO),HttpStatus.CREATED);
	}
	@GetMapping("/view/{locationId}")
	public ResponseEntity<LocationDTO> getLocationByIdHandler(@PathVariable("locationId")Integer locationId) throws LocationNotFoundException{
		return new ResponseEntity<LocationDTO>(locationService.getLocationById(locationId),HttpStatus.OK);
	}
	@DeleteMapping("/delete/{locationId}")
	public ResponseEntity<String> deleteLocationHandler(@PathVariable("locationId")Integer locationId) throws LocationNotFoundException{
		return new ResponseEntity<String>(locationService.deleteLocation(locationId),HttpStatus.ACCEPTED);
	}
	@GetMapping("/viewall")
	public ResponseEntity<List<LocationDTO>> getAllLocationHandler() throws LocationNotFoundException{
		return new ResponseEntity<List<LocationDTO>>(locationService.getAllLocation(),HttpStatus.ACCEPTED);
	}
	@PutMapping("/update/{locationId}")
	public ResponseEntity<LocationDTO> updateLocationByIdHandler(@PathVariable("locationId")Integer locationId,@RequestBody LocationDTO locationDTO) throws LocationNotFoundException{
		return new ResponseEntity<LocationDTO>(locationService.updateLocationDto(locationId, locationDTO),HttpStatus.OK);
	}
	
	
	
}
