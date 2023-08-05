package com.jsp.onlinepharmacy.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class BookingDto {
	private int bookingId;
	private LocalDate orderDate;
	private int quantity;
	private String payMentMode;
	private LocalDate expectedDate;
}
