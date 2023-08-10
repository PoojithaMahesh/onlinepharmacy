package com.jsp.onlinepharmacy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.onlinepharmacy.util.ResponseStructure;

@RestControllerAdvice
public class OnlinePharmacyExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> addressIdNotFoundException(AddressIdNotFoundException  ex){
		 ResponseStructure<String> structure=new  ResponseStructure<String>();
		 structure.setMessage("AddressId Not Found");
		 structure.setStatus(HttpStatus.NOT_FOUND.value());
		 structure.setData(ex.getMessage());
		 return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> adminIdNotFoundException(AdminIdNotFoundException  ex){
		 ResponseStructure<String> structure=new  ResponseStructure<String>();
		 structure.setMessage("Admin Id Not Found");
		 structure.setStatus(HttpStatus.NOT_FOUND.value());
		 structure.setData(ex.getMessage());
		 return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
}
