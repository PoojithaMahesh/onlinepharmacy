package com.jsp.onlinepharmacy.dto;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicalStoreDto {
	private int storeId;
	private String name;
	private String managerName;
	private long phone;
	
	@ManyToOne
	private AdminDto adminDto;
	
	@OneToOne
	private AddressDto addressDto; 
}
