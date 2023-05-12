package com.airbnb.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListingDTO {

	private Integer listingId;
	
	private String title;
	
	private String description;
	
	private double price; 
	
	private Integer guestLimits;
	
	private UsersDTO usersDTO;

	private LocationDTO locationDTO;
}
