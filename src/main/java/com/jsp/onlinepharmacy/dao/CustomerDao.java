package com.jsp.onlinepharmacy.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.onlinepharmacy.entity.Customer;
import com.jsp.onlinepharmacy.repository.CustomerRepo;

@Repository
public class CustomerDao {
	
	@Autowired
	private CustomerRepo repo;

	public Customer saveCustomer(Customer customer) {
		return repo.save(customer);
	}

}
