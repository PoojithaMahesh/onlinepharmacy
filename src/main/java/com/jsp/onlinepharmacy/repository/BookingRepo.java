package com.jsp.onlinepharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.onlinepharmacy.entity.Booking;

public interface BookingRepo extends JpaRepository<Booking, Integer>{

}
