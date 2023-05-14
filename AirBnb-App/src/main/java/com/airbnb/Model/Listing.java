package com.airbnb.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="listing")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Listing {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer listingId;
	
	private String title;
	
	private String description;
	
	private double price; 
	@Column(name="guest_limit",nullable = false)
	private Integer guestLimits;
	

	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "hostId")
	private Users user;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "locationId")
	private Location location;
	
//	@ManyToMany
//	@JoinTable(name="ListingAmenities",
//		joinColumns = @JoinColumn(name="listing_Id", referencedColumnName = "listingId"),
//		inverseJoinColumns = @JoinColumn(name="amenity_id", referencedColumnName = "amenityId"))
//	private List<Amenities> amenities=new ArrayList<>();
	
	@OneToMany
	private List<ListingAmenities> listingAmenities;
	
}
