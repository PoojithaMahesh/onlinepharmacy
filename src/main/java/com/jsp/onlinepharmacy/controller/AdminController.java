package com.jsp.onlinepharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.onlinepharmacy.dto.AdminDto;
import com.jsp.onlinepharmacy.entity.Admin;
import com.jsp.onlinepharmacy.service.AdminService;
import com.jsp.onlinepharmacy.util.ResponseStructure;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<AdminDto>> saveAdmin
	(@RequestBody Admin admin){
		return service.saveAdmin(admin);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<AdminDto>> updateAdmin
	(@RequestParam int id,@RequestBody Admin admin){
		return service.updateAdmin(id,admin);
	}

}
