package com.jsp.onlinepharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.onlinepharmacy.dto.CustomerDto;
import com.jsp.onlinepharmacy.entity.Customer;
import com.jsp.onlinepharmacy.service.CustomerService;
import com.jsp.onlinepharmacy.util.ResponseStructure;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	
	@PostMapping
	public ResponseEntity<ResponseStructure<CustomerDto>> addCustomer(@RequestParam int addressId,
			@RequestBody Customer customer){
		return service.addCustomer(addressId,customer);
	}
}