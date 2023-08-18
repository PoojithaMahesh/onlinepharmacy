package com.jsp.onlinepharmacy.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.onlinepharmacy.dao.AddressDao;
import com.jsp.onlinepharmacy.dao.CustomerDao;
import com.jsp.onlinepharmacy.dto.AddressDto;
import com.jsp.onlinepharmacy.dto.BookingDto;
import com.jsp.onlinepharmacy.dto.CustomerDto;
import com.jsp.onlinepharmacy.entity.Address;
import com.jsp.onlinepharmacy.entity.Customer;
import com.jsp.onlinepharmacy.exception.AddressIdNotFoundException;
import com.jsp.onlinepharmacy.util.ResponseStructure;

@Service
public class CustomerService {
	@Autowired
	private CustomerDao custmerDao;
	@Autowired
	private AddressDao addressDao;
	@Autowired
	private ModelMapper modelMapper;

	public ResponseEntity<ResponseStructure<CustomerDto>> addCustomer(int addressId, Customer customer) {
		Address dbAddress=addressDao.findAddressById(addressId);
//		checking addressId is present or not
		if(dbAddress!=null) {
//			yes addressId is present
			List<Address> addresses=new ArrayList<Address>();
			addresses.add(dbAddress);
//			customer=only the own attributes not a relationship attributes
			customer.setAddresses(addresses);
//			now customer is having adddress also
			Customer dbCustomer=custmerDao.saveCustomer(customer);
//	dbCustomer is having its own attributes then relationship attributes that is List address and List of bookings but its null
//			but list  of address is present
//			Copy Customer to customerDto
//			but this customer dto is having ListofaddresssesDto and ListOfBooking dto but still it is null;
//			copy List of Addressto addressDto
			CustomerDto customerDto=this.modelMapper.map(dbCustomer, CustomerDto.class);
			List<AddressDto> addressDtos;
		for(Address address:dbCustomer.getAddresses()) {
			AddressDto addressDto=this.modelMapper.map(address, AddressDto.class);
			addressDtos=new ArrayList<AddressDto>();
			addressDtos.add(addressDto);
			customerDto.setAddresses(addressDtos);
		} 
			customerDto.setBookingDtos(null);
			ResponseStructure<CustomerDto> structure=new ResponseStructure<CustomerDto>();
			structure.setMessage("CustometrAddedsuccessfully");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(customerDto);
			return new ResponseEntity<ResponseStructure<CustomerDto>>(structure,HttpStatus.CREATED);
			
		}else {
			throw new AddressIdNotFoundException("Sorry failed to add customer");
		}
	}

}
