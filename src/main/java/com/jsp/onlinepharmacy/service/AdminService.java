package com.jsp.onlinepharmacy.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.onlinepharmacy.dao.AdminDao;
import com.jsp.onlinepharmacy.dto.AdminDto;
import com.jsp.onlinepharmacy.entity.Admin;
import com.jsp.onlinepharmacy.util.ResponseStructure;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;
	@Autowired
	private ModelMapper modelMapper;

	public ResponseEntity<ResponseStructure<AdminDto>> saveAdmin(Admin admin) {
	   Admin dbAdmin=adminDao.saveAdmin(admin);
	   
	 AdminDto adminDto=this.modelMapper.map(dbAdmin, AdminDto.class);
	 ResponseStructure<AdminDto>  structure=new ResponseStructure<AdminDto>();
	 structure.setMessage("Admin saved successfully");
	 structure.setStatus(HttpStatus.CREATED.value());
	 structure.setData(adminDto);
	 return new ResponseEntity<ResponseStructure<AdminDto>>(structure,HttpStatus.CREATED);	
	}

	public ResponseEntity<ResponseStructure<AdminDto>> updateAdmin(int adminId, Admin admin) {
		Admin dbAdmin=adminDao.updateAdmin(adminId,admin);
		if(dbAdmin!=null) {
			 AdminDto adminDto=this.modelMapper.map(dbAdmin, AdminDto.class);
			 ResponseStructure<AdminDto>  structure=new ResponseStructure<AdminDto>();
			 structure.setMessage("Admin Updated successfully");
			 structure.setStatus(HttpStatus.OK.value());
			 structure.setData(adminDto);
			 return new ResponseEntity<ResponseStructure<AdminDto>>(structure,HttpStatus.OK);
		}else {
//			raise admin id not found exception
			return null;
		}
	}
}
