package com.airbnb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airbnb.Model.Amenities;

public interface AmenitesRepository  extends JpaRepository<Amenities, Integer>{
	
	public Amenities findByAmenityName(String name);

}
