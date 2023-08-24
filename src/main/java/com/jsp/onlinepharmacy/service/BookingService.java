package com.jsp.onlinepharmacy.service;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.onlinepharmacy.dao.BookingDao;
import com.jsp.onlinepharmacy.dao.CustomerDao;
import com.jsp.onlinepharmacy.dao.MedicineDao;
import com.jsp.onlinepharmacy.dto.BookingDto;
import com.jsp.onlinepharmacy.entity.Booking;
import com.jsp.onlinepharmacy.entity.Customer;
import com.jsp.onlinepharmacy.entity.Medicine;
import com.jsp.onlinepharmacy.enums.BookingStatus;
import com.jsp.onlinepharmacy.exception.BookingAlreadyCancelled;
import com.jsp.onlinepharmacy.exception.BookingCantCancelledNow;
import com.jsp.onlinepharmacy.exception.BookingDeliveredException;
import com.jsp.onlinepharmacy.exception.BookingIdNotFoundException;
import com.jsp.onlinepharmacy.exception.CustomerIdNotFoundException;
import com.jsp.onlinepharmacy.exception.MedicineIdNotFoundException;
import com.jsp.onlinepharmacy.util.ResponseStructure;

@Service
public class BookingService {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private BookingDao bookingDao;
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private MedicineDao medicineDao;

	public ResponseEntity<ResponseStructure<Booking>> addBooking(int customerId, int medicineId,
			BookingDto bookingDto) {
		Booking booking = this.modelMapper.map(bookingDto, Booking.class);
		Customer dbCustomer = customerDao.getCustomerById(customerId);
		if (dbCustomer != null) {
//			customer is present
			Medicine dbMedicine = medicineDao.getMedicineByid(medicineId);
			if (dbMedicine != null) {
//			medicine is present

				List<Medicine> medicines = new ArrayList<Medicine>();
				medicines.add(dbMedicine);
				booking.setCustomer(dbCustomer);
				booking.setMedicines(medicines);

//			update customer also
				List<Booking> bookings = new ArrayList<Booking>();
				bookings.add(booking);
				dbCustomer.setBookings(bookings);
				customerDao.updateCustomer(customerId, dbCustomer);
//				updating stock quantity
				dbMedicine.setStockQuantity(dbMedicine.getStockQuantity()-booking.getQuantity());
//				im adding booking status
				booking.setBookingStatus(BookingStatus.ACTIVE);
				
				Booking dbBooking = bookingDao.saveBooking(booking);

				
				ResponseStructure<Booking> structure = new ResponseStructure<Booking>();
				structure.setMessage("Booking added successfully");
				structure.setStatus(HttpStatus.CREATED.value());
				structure.setData(dbBooking);
				return new ResponseEntity<ResponseStructure<Booking>>(structure, HttpStatus.CREATED);

			} else {
				throw new MedicineIdNotFoundException("Sorry failed to add booking");
			}

		} else {
			throw new CustomerIdNotFoundException("Sorry failed to add booking");
		}
	}

	public ResponseEntity<ResponseStructure<Booking>> cancelBooking(int bookingId) {
	Booking dbBooking=bookingDao.findBookingById(bookingId);
		
		
//		Expected date=24
//		cantcancelleddate=24-2=22;
		
		
		if(dbBooking!=null) {
			LocalDate cantcancelledday=dbBooking.getExpectedDate().minusDays(2);
           if(dbBooking.getBookingStatus().equals(BookingStatus.CANCELLED)) {
        	   throw new BookingAlreadyCancelled("sorry this booking already Cancelled");
           }else if(dbBooking.getBookingStatus().equals(BookingStatus.DELIVERED)) {
        	   throw new BookingDeliveredException("Sorry cant cancel Booking its already delivered");
           }else if(LocalDate.now().equals(cantcancelledday)||LocalDate.now().isAfter(cantcancelledday)) {
       			throw new BookingCantCancelledNow("Sorry booking cant cancelled Now");
           }else {
        	   Booking cancelledBooking=bookingDao.cancelBooking(bookingId);
        	   ResponseStructure<Booking> structure=new ResponseStructure<Booking>();
        	   structure.setMessage("Booking cancelled Successfully");
       	   structure.setStatus(HttpStatus.OK.value());
        	   structure.setData(cancelledBooking);
               return new ResponseEntity<ResponseStructure<Booking>>(structure,HttpStatus.OK);       	   
           }
	
		}else {
			throw new BookingIdNotFoundException("Sorry failed to cancel booking");
		}
		
	}

}
