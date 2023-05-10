package com.airbnb.DTO;

import com.airbnb.Model.Location;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class LocationDTO {

	private Integer locationId;
	private String address;
	private String city;
	private String State;
	private String country;
	private String pincode;
	
}
