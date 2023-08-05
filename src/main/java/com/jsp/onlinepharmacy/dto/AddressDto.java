package com.jsp.onlinepharmacy.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {
	private int addressId;
    private String streetName;
    private String city;
    private String state;
    private long pincode;
    
}
