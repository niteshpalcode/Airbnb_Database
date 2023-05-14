package com.airbnb.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> myMANVEHandler(MethodArgumentNotValidException me) {

		MyErrorDetails error = new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage("Validation Error.!");
		error.setDescription(me.getBindingResult().getFieldError().getDefaultMessage());

		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(AmenitiesNotFoundException.class)
	public ResponseEntity<MyErrorDetails> myANFEHandler(AmenitiesNotFoundException an, WebRequest wr) {

		MyErrorDetails error = new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(an.getMessage());
		error.setDescription(wr.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(BookingNotFoundException.class)
	public ResponseEntity<MyErrorDetails> myBNFEHandler(BookingNotFoundException bn, WebRequest wr) {

		MyErrorDetails error = new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(bn.getMessage());
		error.setDescription(wr.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(ListingNotFoundException.class)
	public ResponseEntity<MyErrorDetails> myLNFEHandler(ListingNotFoundException ln, WebRequest wr) {

		MyErrorDetails error = new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(ln.getMessage());
		error.setDescription(wr.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(LocationNotFoundException.class)
	public ResponseEntity<MyErrorDetails> myLoNFEHandler(LocationNotFoundException ln, WebRequest wr) {

		MyErrorDetails error = new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(ln.getMessage());
		error.setDescription(wr.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(RoleNotFoundException.class)
	public ResponseEntity<MyErrorDetails> myRNFEHandler(RoleNotFoundException rn, WebRequest wr) {

		MyErrorDetails error = new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(rn.getMessage());
		error.setDescription(wr.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(ReviewNotFoundException.class)
	public ResponseEntity<MyErrorDetails> myReNFEHandler(ReviewNotFoundException rn, WebRequest wr) {

		MyErrorDetails error = new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(rn.getMessage());
		error.setDescription(wr.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(UsersNotfoundException.class)
	public ResponseEntity<MyErrorDetails> myUNFEHandler(UsersNotfoundException un, WebRequest wr) {

		MyErrorDetails error = new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(un.getMessage());
		error.setDescription(wr.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(LoginNotFoundException.class)
	public ResponseEntity<MyErrorDetails> myLogNFEHandler(LoginNotFoundException ln, WebRequest wr) {

		MyErrorDetails error = new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(ln.getMessage());
		error.setDescription(wr.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(ListingAmenitiesException.class)
	public ResponseEntity<MyErrorDetails> myListingNFEHandler(ListingAmenitiesException ln, WebRequest wr) {

		MyErrorDetails error = new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(ln.getMessage());
		error.setDescription(wr.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}
}
