package com.jsp.onlinepharmacy.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.onlinepharmacy.dao.AdminDao;
import com.jsp.onlinepharmacy.dao.MedicalStoreDao;
import com.jsp.onlinepharmacy.dao.StaffDao;
import com.jsp.onlinepharmacy.dto.AdminDto;
import com.jsp.onlinepharmacy.dto.MedicalStoreDto;
import com.jsp.onlinepharmacy.dto.StaffDto;
import com.jsp.onlinepharmacy.entity.Admin;
import com.jsp.onlinepharmacy.entity.MedicalStore;
import com.jsp.onlinepharmacy.entity.Staff;
import com.jsp.onlinepharmacy.exception.AdminIdNotFoundException;
import com.jsp.onlinepharmacy.exception.MedicalStoreIdNotFoundException;
import com.jsp.onlinepharmacy.exception.StaffIdNOtFoundException;
import com.jsp.onlinepharmacy.util.ResponseStructure;

@Service
public class StaffService {
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private StaffDao staffDao;
	@Autowired
	private MedicalStoreDao medicalStoreDao;
	@Autowired
	private AdminDao adminDao;

	public ResponseEntity<ResponseStructure<StaffDto>> addStaff(int adminId, int storeId, Staff staff) {
		MedicalStore dbMedicalStore=medicalStoreDao.getMedicalStoreById(storeId);
		if(dbMedicalStore!=null) {
			staff.setMedicalStore(dbMedicalStore);
			Admin dbAdmin=adminDao.findADminById(adminId);
			if(dbAdmin!=null) {
				staff.setAdmin(dbAdmin);
				Staff dbStaff=staffDao.saveStaff(staff);
				
				StaffDto dbStaffDto=this.modelMapper.map(dbStaff, StaffDto.class);
				dbStaffDto.setAdminDto(this.modelMapper.map(dbStaff.getAdmin(), AdminDto.class));
				dbStaffDto.setMedicalStoreDto(this.modelMapper.map(dbStaff.getMedicalStore(), MedicalStoreDto.class));
				
				ResponseStructure<StaffDto> structure=new ResponseStructure<StaffDto>();
				structure.setMessage("Staff Added successfully");
				structure.setStatus(HttpStatus.CREATED.value());
				structure.setData(dbStaffDto);
				return new ResponseEntity<ResponseStructure<StaffDto>>(structure,HttpStatus.CREATED);
				
			}else {
				throw new AdminIdNotFoundException("Sorry failed to add staff");
			}
		
		}else {
			throw new MedicalStoreIdNotFoundException("Sorry failed to add staff");
		}
	}

	public ResponseEntity<ResponseStructure<StaffDto>> updateStaff(int staffId, Staff staff) {
		Staff dbStaff=staffDao.updateStaff(staffId,staff);
		if(dbStaff!=null){
			StaffDto dbStaffDto=this.modelMapper.map(dbStaff, StaffDto.class);
			dbStaffDto.setAdminDto(this.modelMapper.map(dbStaff.getAdmin(), AdminDto.class));
			dbStaffDto.setMedicalStoreDto(this.modelMapper.map(dbStaff.getMedicalStore(), MedicalStoreDto.class));
			
			ResponseStructure<StaffDto> structure=new ResponseStructure<StaffDto>();
			structure.setMessage("Staff updated successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dbStaffDto);
			return new ResponseEntity<ResponseStructure<StaffDto>>(structure,HttpStatus.OK);
	
		}else {
			throw new StaffIdNOtFoundException("sorry failed to update STaff");
		}

	}

	public ResponseEntity<ResponseStructure<StaffDto>> getStaffById(int staffId) {
	 Staff dbStaff=staffDao.getStaffById(staffId);
	 if(dbStaff!=null){
			StaffDto dbStaffDto=this.modelMapper.map(dbStaff, StaffDto.class);
			dbStaffDto.setAdminDto(this.modelMapper.map(dbStaff.getAdmin(), AdminDto.class));
			dbStaffDto.setMedicalStoreDto(this.modelMapper.map(dbStaff.getMedicalStore(), MedicalStoreDto.class));
			
			ResponseStructure<StaffDto> structure=new ResponseStructure<StaffDto>();
			structure.setMessage("Staff data fetched successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dbStaffDto);
			return new ResponseEntity<ResponseStructure<StaffDto>>(structure,HttpStatus.OK);
	
		}else {
			throw new StaffIdNOtFoundException("sorry failed to get Staff");
		}

	}

	public ResponseEntity<ResponseStructure<StaffDto>> deleteStaffById(int staffId) {
		Staff dbStaff=staffDao.deleteStaffById(staffId);
		if(dbStaff!=null){
			StaffDto dbStaffDto=this.modelMapper.map(dbStaff, StaffDto.class);
			dbStaffDto.setAdminDto(this.modelMapper.map(dbStaff.getAdmin(), AdminDto.class));
			dbStaffDto.setMedicalStoreDto(this.modelMapper.map(dbStaff.getMedicalStore(), MedicalStoreDto.class));
			
			ResponseStructure<StaffDto> structure=new ResponseStructure<StaffDto>();
			structure.setMessage("Staff data deleted successfully");
			structure.setStatus(HttpStatus.GONE.value());
			structure.setData(dbStaffDto);
			return new ResponseEntity<ResponseStructure<StaffDto>>(structure,HttpStatus.GONE);
	
		}else {
			throw new StaffIdNOtFoundException("sorry failed to delete Staff");
		}
	}
	
	
}
