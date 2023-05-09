package com.airbnb.Model;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name="location")
@Data
@Getter
@Setter
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer locationId;
	private String address;
	private String city;
	private String State;
	private String country;
	private String pincode;
	

}
