package com.jsp.onlinepharmacy.dto;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StaffDto {
	private int staffId;
	private String staffName;
	private String email;
	private long phoneNumber;
	@ManyToOne
	private AdminDto adminDto;
	@OneToOne
	private MedicalStoreDto medicalStoreDto;
}
