package com.jsp.onlinepharmacy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.onlinepharmacy.dao.AddressDao;
import com.jsp.onlinepharmacy.dto.AddressDto;
import com.jsp.onlinepharmacy.entity.Address;
import com.jsp.onlinepharmacy.util.ResponseStructure;

@Service
public class AddressService {
	
	@Autowired
	private AddressDao addressDao;

	public ResponseEntity<ResponseStructure<AddressDto>> saveAddress(Address address) {
		Address dbAddress=addressDao.saveAddress(address);
		AddressDto dto=new AddressDto();
		dto.setAddressId(dbAddress.getAddressId());
		dto.setCity(dbAddress.getCity());
		dto.setPincode(dbAddress.getPincode());
		dto.setState(dbAddress.getState());
		dto.setStreetName(dbAddress.getStreetName());
		ResponseStructure<AddressDto> structure=new ResponseStructure<AddressDto>();
		structure.setMessage("Address Saved successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dto);
		return new ResponseEntity<ResponseStructure<AddressDto>>(structure,HttpStatus.CREATED);
	}

}
