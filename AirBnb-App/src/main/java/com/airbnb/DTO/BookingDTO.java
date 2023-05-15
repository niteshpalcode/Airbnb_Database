package com.airbnb.DTO;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.airbnb.Model.Bookings;
import com.airbnb.Model.Listing;

import com.airbnb.Model.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {
	private Integer bookingId;
	
	private LocalDate checkIn;
	
	private LocalDate checkOut;
	
	private double totalPrice;

	private String status;
	
	private UserDTO1 usersDTO;
	
	private ListingDTO1 listingDTO;
	
	
	
}
