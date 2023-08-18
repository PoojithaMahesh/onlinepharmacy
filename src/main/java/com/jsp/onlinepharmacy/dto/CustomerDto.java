package com.jsp.onlinepharmacy.dto;

import java.util.List;

import javax.persistence.OneToMany;

import com.jsp.onlinepharmacy.entity.Address;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {
	private int customerId;
	private String customerName;
	private String Email;
	private long phoneNumber;
	
	@OneToMany
	private List<AddressDto> addresses;
	
	@OneToMany
	private List<BookingDto> bookingDtos;
}
