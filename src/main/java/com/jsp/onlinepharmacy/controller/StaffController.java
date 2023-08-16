package com.jsp.onlinepharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.onlinepharmacy.dto.StaffDto;
import com.jsp.onlinepharmacy.entity.Staff;
import com.jsp.onlinepharmacy.service.StaffService;
import com.jsp.onlinepharmacy.util.ResponseStructure;

@RestController
@RequestMapping("/staff")
public class StaffController {
	
	
	@Autowired
	private StaffService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<StaffDto>> addStaff(@RequestParam int adminId,
			@RequestParam int storeId,@RequestBody Staff staff ){
		return service.addStaff(adminId,storeId,staff);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<StaffDto>> updateStaff(@RequestParam int staffId,@RequestBody Staff staff){
		return service.updateStaff(staffId,staff);
	}

}
