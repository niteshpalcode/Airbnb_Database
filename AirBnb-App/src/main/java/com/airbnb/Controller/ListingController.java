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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airbnb.DTO.ListingDTO;
import com.airbnb.Exception.ListingNotFoundException;
import com.airbnb.Exception.LocationNotFoundException;
import com.airbnb.Exception.UsersNotfoundException;
import com.airbnb.Model.ListingResponse;
import com.airbnb.Security.AppConstant;
import com.airbnb.Service.ListingService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/listing")
public class ListingController {

	@Autowired
	private ListingService listingService;
	
	@PostMapping("/save/User/{userId}/Location/{locationId}")
	public ResponseEntity<ListingDTO> addNewListing(@RequestBody ListingDTO listingDTO,
					@PathVariable("userId") Integer userId, @PathVariable("locationId") Integer locationId) 
							throws UsersNotfoundException,LocationNotFoundException,ListingNotFoundException{
			return new ResponseEntity<ListingDTO>(listingService.createListing(userId, locationId, listingDTO),HttpStatus.CREATED);
	}
	@DeleteMapping("/delete/User/{userId}/Listing/{listingId}")
	public ResponseEntity<String>deleteListingHandler(@PathVariable("userId") Integer userId, @PathVariable("listingId") Integer listingId)
			throws ListingNotFoundException,UsersNotfoundException{
		return new ResponseEntity<String>(listingService.deleteListing(userId, listingId),HttpStatus.OK);
	}
	@PutMapping("/update/listing{listingId}")
	public ResponseEntity<ListingDTO> uppdateListing(@RequestBody ListingDTO listingDTO,
			@PathVariable("listingId") Integer listingId) 
					throws ListingNotFoundException{
	return new ResponseEntity<ListingDTO>(listingService.updateListing(listingDTO, listingId),HttpStatus.CREATED);
}
	
	@GetMapping("/view/user/{userId}")
	public ResponseEntity<List<ListingDTO>>getaAllListingByUser(@PathVariable ("userId")Integer userId)throws ListingNotFoundException,UsersNotfoundException{
		return new ResponseEntity<List<ListingDTO>>(listingService.getAllListingByUser(userId),HttpStatus.ACCEPTED);
	}
	@GetMapping("/view/listing/{listingId}")
	public ResponseEntity<ListingDTO>getaAllListingById(@PathVariable ("listingId")Integer listingId)throws ListingNotFoundException{
		return new ResponseEntity<ListingDTO>(listingService.getListing(listingId),HttpStatus.ACCEPTED);
	}
	@GetMapping("/view/Alllisting")
	public ResponseEntity<List<ListingDTO>>getaAllListing()throws ListingNotFoundException{
		return new ResponseEntity<List<ListingDTO>>(listingService.getAllListingDetails(),HttpStatus.ACCEPTED);
	}
	@GetMapping("/search/listing/{keyword}")
	public ResponseEntity<List<ListingDTO>>searchBytitle(@PathVariable ("keyword")String keyword)throws ListingNotFoundException{
		return new ResponseEntity<List<ListingDTO>>(listingService.searchByTitle(keyword),HttpStatus.ACCEPTED);
	}
	@GetMapping("/page/User/{userId}")
	public ResponseEntity<ListingResponse>searchByUserPageination(@PathVariable ("userId")Integer userId,
							@RequestParam (value = "pageNo",defaultValue = AppConstant.PAGE_NO ,required = false )Integer pageNo,
							@RequestParam (value = "pageSize",defaultValue = AppConstant.PAGE_SIZE,required = false )Integer pageSize)
									throws UsersNotfoundException,ListingNotFoundException{
		return new ResponseEntity<ListingResponse>(listingService.getAllListingByUser(userId, pageNo, pageSize),HttpStatus.ACCEPTED);
	}
	@GetMapping("/search/description/{key}")
	public ResponseEntity<List<ListingDTO>>searchByDescription(@PathVariable ("key")String key){
		return new ResponseEntity<List<ListingDTO>>(listingService.searchByDescription(key),HttpStatus.ACCEPTED);
	}
}
