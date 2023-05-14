package com.airbnb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airbnb.Model.ListingAmenities;

public interface ListingAmenitiesRepository extends JpaRepository<ListingAmenities, Integer> {

}
