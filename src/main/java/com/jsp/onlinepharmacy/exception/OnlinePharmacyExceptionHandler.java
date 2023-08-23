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
	public ResponseEntity<ResponseStructure<String>> staffIdNotFoundException(StaffIdNOtFoundException  ex){
		 ResponseStructure<String> structure=new  ResponseStructure<String>();
		 structure.setMessage("STaff Not Found");
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
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> medicineIdNotFoundException(MedicineIdNotFoundException  ex){
		 ResponseStructure<String> structure=new  ResponseStructure<String>();
		 structure.setMessage("Medicine Id Not Found");
		 structure.setStatus(HttpStatus.NOT_FOUND.value());
		 structure.setData(ex.getMessage());
		 return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> customerIdNotFoundException(CustomerIdNotFoundException  ex){
		 ResponseStructure<String> structure=new  ResponseStructure<String>();
		 structure.setMessage("Customer Id Not Found");
		 structure.setStatus(HttpStatus.NOT_FOUND.value());
		 structure.setData(ex.getMessage());
		 return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> addressAlreadyMapped(AddressAlreadyMappedToOtherCustomer  ex){
		 ResponseStructure<String> structure=new  ResponseStructure<String>();
		 structure.setMessage("address already mapped to exception");
		 structure.setStatus(HttpStatus.NOT_FOUND.value());
		 structure.setData(ex.getMessage());
		 return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> addressAlreadyMapped(AddressMappedToMedicalStore  ex){
		 ResponseStructure<String> structure=new  ResponseStructure<String>();
		 structure.setMessage("address already mapped to exception");
		 structure.setStatus(HttpStatus.NOT_FOUND.value());
		 structure.setData(ex.getMessage());
		 return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> addressAlreadyMapped(AddressAlreadymappedtoCustomer  ex){
		 ResponseStructure<String> structure=new  ResponseStructure<String>();
		 structure.setMessage("address already mapped  exception");
		 structure.setStatus(HttpStatus.NOT_FOUND.value());
		 structure.setData(ex.getMessage());
		 return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> storeIdNotFoundException(MedicalStoreIdNotFoundException  ex){
		 ResponseStructure<String> structure=new  ResponseStructure<String>();
		 structure.setMessage("Store Id Not Found");
		 structure.setStatus(HttpStatus.NOT_FOUND.value());
		 structure.setData(ex.getMessage());
		 return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> bookingalreadycancelldException(BookingAlreadyCancelled  ex){
		 ResponseStructure<String> structure=new  ResponseStructure<String>();
		 structure.setMessage("Booking Already cancelled");
		 structure.setStatus(HttpStatus.NOT_FOUND.value());
		 structure.setData(ex.getMessage());
		 return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> bookingalreadydeliveredException(BookingDeliveredException  ex){
		 ResponseStructure<String> structure=new  ResponseStructure<String>();
		 structure.setMessage("Booking Already delievered");
		 structure.setStatus(HttpStatus.NOT_FOUND.value());
		 structure.setData(ex.getMessage());
		 return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> bookingException(BookingCantCancelledNow  ex){
		 ResponseStructure<String> structure=new  ResponseStructure<String>();
		 structure.setMessage("Booking Cant cancelled now because expected date is near");
		 structure.setStatus(HttpStatus.NOT_FOUND.value());
		 structure.setData(ex.getMessage());
		 return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> bookingIdNotFoundException(BookingIdNotFoundException  ex){
		 ResponseStructure<String> structure=new  ResponseStructure<String>();
		 structure.setMessage("Booking Id Not Found");
		 structure.setStatus(HttpStatus.NOT_FOUND.value());
		 structure.setData(ex.getMessage());
		 return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
}
