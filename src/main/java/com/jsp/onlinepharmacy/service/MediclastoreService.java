package com.jsp.onlinepharmacy.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.onlinepharmacy.dao.AddressDao;
import com.jsp.onlinepharmacy.dao.AdminDao;
import com.jsp.onlinepharmacy.dao.MedicalStoreDao;
import com.jsp.onlinepharmacy.dto.AddressDto;
import com.jsp.onlinepharmacy.dto.AdminDto;
import com.jsp.onlinepharmacy.dto.MedicalStoreDto;
import com.jsp.onlinepharmacy.entity.Address;
import com.jsp.onlinepharmacy.entity.Admin;
import com.jsp.onlinepharmacy.entity.MedicalStore;
import com.jsp.onlinepharmacy.exception.AddressIdNotFoundException;
import com.jsp.onlinepharmacy.exception.AdminIdNotFoundException;
import com.jsp.onlinepharmacy.exception.MedicalStoreIdNotFoundException;
import com.jsp.onlinepharmacy.util.ResponseStructure;

@Service
public class MediclastoreService {
	@Autowired
	private MedicalStoreDao storeDao;
	@Autowired 
	private ModelMapper modelMapper;
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private AddressDao addressDao;

	public ResponseEntity<ResponseStructure<MedicalStoreDto>> saveMedicalStore(int adminId, int addressId,
			MedicalStoreDto medicalStoreDto) {
	
		MedicalStore medicalStore=this.modelMapper.map(medicalStoreDto,MedicalStore.class);
//		this medicalstore is not having admin and address yet
//		so first i need to get that admin
		Admin dbAdmin=adminDao.findADminById(adminId);
//		im checking whether this admin is present or not
	
		if(dbAdmin!=null) {
			  medicalStore.setAdmin(dbAdmin);
		       Address dbAddress= addressDao.findAddressById(addressId);
		       if(dbAddress!=null) {
		    	   medicalStore.setAddress(dbAddress);
		    	   MedicalStore dbMedicalStore=storeDao.saveMedicalStore(medicalStore);
		    	  Address dbMedicalStoreAddress=dbMedicalStore.getAddress();
		    	  AddressDto addressDto=this.modelMapper.map(dbMedicalStoreAddress, AddressDto.class);
		    	  Admin dbMedicalStoreAdmin=dbMedicalStore.getAdmin();
		    	   
		    	   MedicalStoreDto dto=this.modelMapper.map(dbMedicalStore, MedicalStoreDto.class);
		    	   dto.setAddressDto(addressDto);
		           dto.setAdminDto(this.modelMapper.map(dbMedicalStoreAdmin, AdminDto.class));
		    	   ResponseStructure<MedicalStoreDto> structure=new ResponseStructure<MedicalStoreDto>();
		    	   structure.setMessage("MedicalStore added successfully");
		    	   structure.setStatus(HttpStatus.CREATED.value());
		    	   structure.setData(dto);
		    	   return new ResponseEntity<ResponseStructure<MedicalStoreDto>>(structure,HttpStatus.CREATED);
		  
		       }else {
		    	   throw new AddressIdNotFoundException("Sorry failed to add medicalstore");
		       }
      
			
		}else {
			throw new AdminIdNotFoundException("Sorry failed to add medicalstore");
		}
	}

	public ResponseEntity<ResponseStructure<MedicalStoreDto>> updateMedicalStore(int storeId,
			MedicalStore medicalStore) {
//		medicalstore=name,manager name,phone
	MedicalStore dbMedicalStore=storeDao.updateMedicalStore(storeId,medicalStore);
		if(dbMedicalStore!=null) {
			MedicalStoreDto storeDto=this.modelMapper.map(dbMedicalStore, MedicalStoreDto.class);
			storeDto.setAddressDto(this.modelMapper.map(dbMedicalStore.getAddress(), AddressDto.class));
			storeDto.setAdminDto(this.modelMapper.map(dbMedicalStore.getAdmin(), AdminDto.class));
			
			ResponseStructure<MedicalStoreDto> structure=new ResponseStructure<MedicalStoreDto>();
			structure.setMessage("MedicalStoreUpdated successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(storeDto);
			return new ResponseEntity<ResponseStructure<MedicalStoreDto>>(structure,HttpStatus.OK);
		}else {
//			when that id is not present
			throw new MedicalStoreIdNotFoundException("Sorry failed to update medicalstore");
		}
	
	
	}

	public ResponseEntity<ResponseStructure<MedicalStoreDto>> getMedicalStoreById(int storeId) {
		MedicalStore dbMedicalStore=storeDao.getMedicalStoreById(storeId);
		if(dbMedicalStore!=null) {
			MedicalStoreDto storeDto=this.modelMapper.map(dbMedicalStore, MedicalStoreDto.class);
			storeDto.setAddressDto(this.modelMapper.map(dbMedicalStore.getAddress(), AddressDto.class));
			storeDto.setAdminDto(this.modelMapper.map(dbMedicalStore.getAdmin(), AdminDto.class));
			
			ResponseStructure<MedicalStoreDto> structure=new ResponseStructure<MedicalStoreDto>();
			structure.setMessage("MedicalStore fetched successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(storeDto);
			return new ResponseEntity<ResponseStructure<MedicalStoreDto>>(structure,HttpStatus.FOUND);
		}else {
//			when that id is not present
			throw new MedicalStoreIdNotFoundException("Sorry failed to fetch medicalstore");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
