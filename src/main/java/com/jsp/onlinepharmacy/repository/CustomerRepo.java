package com.jsp.onlinepharmacy.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.onlinepharmacy.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{
    @Query("Select c from Customer c where c.Email=?1")
	public Optional<Customer> findByEmail(String email);

}
