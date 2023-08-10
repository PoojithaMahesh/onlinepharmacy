package com.jsp.onlinepharmacy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.onlinepharmacy.dao.AddressDao;
import com.jsp.onlinepharmacy.dto.AddressDto;
import com.jsp.onlinepharmacy.entity.Address;
import com.jsp.onlinepharmacy.exception.AddressIdNotFoundException;
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
		structure.setMessage("Address Saved Successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dto);
		return new ResponseEntity<ResponseStructure<AddressDto>>(structure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<AddressDto>> findAddressById(int addressId) {
		Address dbAddress=addressDao.findAddressById(addressId);
		if(dbAddress!=null) {
			AddressDto dto=new AddressDto();
			dto.setAddressId(dbAddress.getAddressId());
			dto.setCity(dbAddress.getCity());
			dto.setPincode(dbAddress.getPincode());
			dto.setState(dbAddress.getState());
			dto.setStreetName(dbAddress.getStreetName());
			
			ResponseStructure<AddressDto> structure=new ResponseStructure<AddressDto>();
			structure.setMessage("AddressData saved successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<AddressDto>>(structure,HttpStatus.FOUND);
		}else {
		throw new AddressIdNotFoundException("Sorry Failed to fetch the data");
		}
	}

	public ResponseEntity<ResponseStructure<AddressDto>> updateAddress(int addressId, Address address) {
		Address dbAddress=addressDao.updateAddress(addressId,address);
		if(dbAddress!=null) {
			
			AddressDto dto=new AddressDto();
			dto.setAddressId(dbAddress.getAddressId());
			dto.setCity(dbAddress.getCity());
			dto.setPincode(dbAddress.getPincode());
			dto.setState(dbAddress.getState());
			dto.setStreetName(dbAddress.getStreetName());
			
			ResponseStructure<AddressDto> structure=new ResponseStructure<AddressDto>();
			structure.setMessage("Address updated successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<AddressDto>>(structure,HttpStatus.OK);
		}else {
			throw new AddressIdNotFoundException("Sorry Failed to fetch the data");
//			raise the exception addressidnotfoundexception
		}
	}

	public ResponseEntity<ResponseStructure<AddressDto>> deleteAddress(int addressId) {
		Address dbAddress=addressDao.deleteAddressById(addressId);
		if(dbAddress!=null) {
			
			AddressDto dto=new AddressDto();
			dto.setAddressId(dbAddress.getAddressId());
			dto.setCity(dbAddress.getCity());
			dto.setPincode(dbAddress.getPincode());
			dto.setState(dbAddress.getState());
			dto.setStreetName(dbAddress.getStreetName());
			ResponseStructure<AddressDto> structure=new ResponseStructure<AddressDto>();
			structure.setMessage("Address deleted successfully");
			structure.setStatus(HttpStatus.GONE.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<AddressDto>>(structure,HttpStatus.GONE);
		}else {
//			raise the exception
			throw new AddressIdNotFoundException("Sorry Failed to fetch the data");
		}
	}

}
