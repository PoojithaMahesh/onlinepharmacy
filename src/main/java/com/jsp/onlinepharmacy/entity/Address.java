package com.jsp.onlinepharmacy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
    private String streetName;
    private String city;
    private String state;
    private long pincode;
    
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Customer customer;
    
    
    @OneToOne
    @JoinColumn
    private MedicalStore medicalStore;
    
	
}
