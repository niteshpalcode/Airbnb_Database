package com.airbnb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airbnb.Model.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
