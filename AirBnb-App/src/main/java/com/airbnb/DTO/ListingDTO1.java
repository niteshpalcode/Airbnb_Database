package com.airbnb.DTO;

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
public class ListingDTO1 {
	
	private Integer listingId;
	
	private String title;
	
	private String description;
	
	private double price; 
	
	private Integer guestLimits;


	private LocationDTO locationDTO;
}
