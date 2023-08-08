package com.jsp.onlinepharmacy.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.onlinepharmacy.entity.Address;
import com.jsp.onlinepharmacy.repository.AddressRepo;

@Repository
public class AddressDao {

	@Autowired
	private AddressRepo repo;

	public Address saveAddress(Address address) {
		return repo.save(address);
		}

	public Address findAddressById(int addressId) {
	    Optional<Address> optional=repo.findById(addressId);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public Address updateAddress(int addressId, Address address) {
		Optional<Address> optional=repo.findById(addressId);
		if(optional.isEmpty()) {
			return null;
		}
		address.setAddressId(addressId);
		return repo.save(address);
	}

	public Address deleteAddressById(int addressId) {
	Optional<Address> optional=repo.findById(addressId);
	if(optional.isPresent()) {
		Address address=optional.get();
		repo.delete(address);
		return address;
	}
		return null;
	}
}
