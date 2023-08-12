package com.jsp.onlinepharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.onlinepharmacy.dto.MedicalStoreDto;
import com.jsp.onlinepharmacy.entity.MedicalStore;
import com.jsp.onlinepharmacy.service.MediclastoreService;
import com.jsp.onlinepharmacy.util.ResponseStructure;

@RestController
@RequestMapping("/store")
public class MedicalStoreController {

	@Autowired
	private MediclastoreService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<MedicalStoreDto>> saveMedicalStore
	(@RequestParam int adminId,@RequestParam int addressId, @RequestBody MedicalStoreDto medicalStoreDto){
		return service.saveMedicalStore(adminId,addressId,medicalStoreDto);
	}
	
	
	
	
	
	
	
	
}
