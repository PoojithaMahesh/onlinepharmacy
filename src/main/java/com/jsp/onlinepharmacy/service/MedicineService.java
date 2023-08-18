package com.jsp.onlinepharmacy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.onlinepharmacy.dao.MedicalStoreDao;
import com.jsp.onlinepharmacy.dao.MedicineDao;
import com.jsp.onlinepharmacy.entity.MedicalStore;
import com.jsp.onlinepharmacy.entity.Medicine;
import com.jsp.onlinepharmacy.exception.MedicalStoreIdNotFoundException;
import com.jsp.onlinepharmacy.exception.MedicineIdNotFoundException;
import com.jsp.onlinepharmacy.util.ResponseStructure;

@Service
public class MedicineService {
	@Autowired
	private MedicineDao medicineDao;
	@Autowired
	private MedicalStoreDao  storeDao;

	public ResponseEntity<ResponseStructure<Medicine>> saveMedicine(int storeId, Medicine medicine) {
		MedicalStore dbMedicalStore=storeDao.getMedicalStoreById(storeId);
		if(dbMedicalStore!=null) {
			medicine.setMedicalStore(dbMedicalStore);
			Medicine dbMedicine=medicineDao.saveMedicine(medicine);
			
			ResponseStructure<Medicine> structure=new ResponseStructure<Medicine>();
			structure.setMessage("medicine added successfully");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(dbMedicine);
			return new ResponseEntity<ResponseStructure<Medicine>>(structure,HttpStatus.CREATED);
			
		}else {
			throw new MedicalStoreIdNotFoundException("Sorry failed to add medicine");
		}
	}

	public ResponseEntity<ResponseStructure<Medicine>> updateMedicine(int medicineId, Medicine medicine) {
	  Medicine dbMedicine=medicineDao.updateMedicine(medicineId,medicine);
		if(dbMedicine!=null) {
			ResponseStructure<Medicine> structure=new ResponseStructure<Medicine>();
			structure.setMessage("medicine updated successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dbMedicine);
			return new ResponseEntity<ResponseStructure<Medicine>>(structure,HttpStatus.OK);
		}else {
			throw new MedicineIdNotFoundException("Sorry failed to update Medicine");
		}
	}

	public ResponseEntity<ResponseStructure<Medicine>> getMedicine(int medicineId) {
		Medicine dbMedicine=medicineDao.getMedicineByid(medicineId);
		if(dbMedicine!=null) {
			ResponseStructure<Medicine> structure=new ResponseStructure<Medicine>();
			structure.setMessage("medicine fetched successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dbMedicine);
			return new ResponseEntity<ResponseStructure<Medicine>>(structure,HttpStatus.FOUND);
		}else {
			throw new MedicineIdNotFoundException("Sorry failed to fetch Medicine");
		}
	}

	public ResponseEntity<ResponseStructure<Medicine>> deleteMedicine(int medicineId) {
	Medicine dbMedicine=medicineDao.deleteMedicineById(medicineId);
	if(dbMedicine!=null) {
		ResponseStructure<Medicine> structure=new ResponseStructure<Medicine>();
		structure.setMessage("medicine deleted successfully");
		structure.setStatus(HttpStatus.GONE.value());
		structure.setData(dbMedicine);
		return new ResponseEntity<ResponseStructure<Medicine>>(structure,HttpStatus.GONE);
	}else {
		throw new MedicineIdNotFoundException("Sorry failed to delete Medicine");
	}
	}

}
