package com.jsp.onlinepharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.onlinepharmacy.entity.Medicine;

public interface MedicineRepo extends JpaRepository<Medicine, Integer>{

}
