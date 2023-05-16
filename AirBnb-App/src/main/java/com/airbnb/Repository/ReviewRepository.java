package com.airbnb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airbnb.Model.Reviews;

public interface ReviewRepository extends JpaRepository<Reviews, Integer>{
	

}
