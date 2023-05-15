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

import com.airbnb.DTO.BookingDTO;
import com.airbnb.DTO.BookingObjDto;
import com.airbnb.Exception.BookingNotFoundException;
import com.airbnb.Exception.ListingNotFoundException;
import com.airbnb.Exception.UsersNotfoundException;
import com.airbnb.Service.BookingService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	
	@PostMapping("/add/user/{userid}/listing/{listingid}")
	public ResponseEntity<BookingDTO> saveBookingHandleer(@RequestBody BookingDTO bookingDTO,@PathVariable("userid") Integer userid,@PathVariable("listingid") Integer listingid)
	throws UsersNotfoundException,ListingNotFoundException,BookingNotFoundException{
		return new ResponseEntity<BookingDTO>(bookingService.createBookingByUser(userid, listingid, bookingDTO),HttpStatus.CREATED);
	}
	@DeleteMapping("delete/userid/{userid}/bookingid/{bookingid}")
	public ResponseEntity<String> deleteBookingHandler(@PathVariable("userid") Integer userid,@PathVariable("bookingid") Integer bookingid) throws 
		UsersNotfoundException,BookingNotFoundException{
		return new ResponseEntity<String>(bookingService.deleteBooking(userid, bookingid),HttpStatus.OK);
	}
	@GetMapping("/view/bookingid/{bookingid}")
	public ResponseEntity<BookingDTO> viewByBookingId(@PathVariable("bookingid")Integer bookingid)throws BookingNotFoundException{
		return new ResponseEntity<BookingDTO>(bookingService.getBookingById(bookingid),HttpStatus.OK);
	}
	@GetMapping("/viewall")
	public ResponseEntity<List<BookingDTO>> viewAllBBooking()throws BookingNotFoundException{
		return new ResponseEntity<List<BookingDTO>>(bookingService.getAllBooking(),HttpStatus.OK);
	}
	@PutMapping("/update/bookingid/{bookingid}")
	public ResponseEntity<BookingObjDto> updateBookingHandleer(@RequestBody BookingObjDto bookingDTO,@PathVariable("bookingid") Integer bookingid)
	throws BookingNotFoundException{
		return new ResponseEntity<BookingObjDto>(bookingService.updateBooking(bookingid, bookingDTO),HttpStatus.CREATED);
	}
	
}
