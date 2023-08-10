package com.jsp.onlinepharmacy.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.onlinepharmacy.entity.MedicalStore;
import com.jsp.onlinepharmacy.repository.MedicalStoreRepo;

@Repository
public class MedicalStoreDao {
	@Autowired
	private MedicalStoreRepo repo;

	public MedicalStore saveMedicalStore(MedicalStore medicalStore) {
	
		return repo.save(medicalStore);
	}
	

}
