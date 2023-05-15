package com.airbnb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airbnb.Model.Bookings;

public interface BookingRepository  extends JpaRepository<Bookings, Integer>{

}
