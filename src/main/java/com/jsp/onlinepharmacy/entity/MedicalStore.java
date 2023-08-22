package com.jsp.onlinepharmacy.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MedicalStore {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int storeId;
	private String name;
	private String managerName;
	private long phone;
	
	@ManyToOne
	@JsonIgnore
	private Admin admin;
	
	@OneToOne(mappedBy = "medicalStore")
	private Address address;
	

}
