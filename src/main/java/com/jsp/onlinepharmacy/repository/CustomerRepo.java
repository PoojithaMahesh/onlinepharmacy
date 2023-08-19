package com.jsp.onlinepharmacy.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.onlinepharmacy.entity.Address;
import com.jsp.onlinepharmacy.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

}
