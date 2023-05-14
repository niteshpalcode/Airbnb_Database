package com.airbnb.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="amenities")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Amenities {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer amenityId;
	@Column(name ="amenity_name" )
	private String amenityName;
	
	@OneToMany
	private List<ListingAmenities> listingAmenities;
	
	

}
