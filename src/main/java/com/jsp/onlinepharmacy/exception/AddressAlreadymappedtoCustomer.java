package com.jsp.onlinepharmacy.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddressAlreadymappedtoCustomer extends RuntimeException {
private String message;
}
