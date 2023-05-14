package com.airbnb.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="ListingAmenities")
@Data
@Getter
@Setter
public class ListingAmenities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer listingAmenityId;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "listing_id")
	@JsonIgnore
	private Listing listing;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "amenity_id")
	@JsonIgnore
	private Amenities amenities;
	
}
