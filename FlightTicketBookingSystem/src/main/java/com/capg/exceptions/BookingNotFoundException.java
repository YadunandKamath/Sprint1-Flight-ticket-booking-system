package com.capg.exceptions;

public class BookingNotFoundException extends RuntimeException{
	
	private String message;
	
	public BookingNotFoundException() {
		
	}
	
	public BookingNotFoundException(String message) {
		super(message);
		this.message=message;
	}
	
}
