package com.airbnb.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.airbnb.Model.Listing;
import com.airbnb.Model.Users;

public interface ListingRepository extends JpaRepository<Listing, Integer>{

	public List<Listing> findByUser(Users user);
	
	public List<Listing> findByTitleContainingIgnoreCase(String title);
	
	Page<Listing> findByUser(Users user, Pageable pageable);
	
	@Query("Select l from Listing l where l.description Like:key")
	public List<Listing> findByDescritption(@Param("key") String key);
	
}
