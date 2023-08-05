package com.jsp.onlinepharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.onlinepharmacy.dto.AddressDto;
import com.jsp.onlinepharmacy.entity.Address;
import com.jsp.onlinepharmacy.service.AddressService;
import com.jsp.onlinepharmacy.util.ResponseStructure;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<AddressDto>> saveAddress(@RequestBody Address address){
		return service.saveAddress(address);
	}
}
