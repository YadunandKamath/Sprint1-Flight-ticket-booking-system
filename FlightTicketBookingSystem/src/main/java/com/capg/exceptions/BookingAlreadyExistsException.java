package com.capg.exceptions;

public class BookingAlreadyExistsException extends RuntimeException{
	
	private String message;
	
	public BookingAlreadyExistsException() {
		
	}
	
	public BookingAlreadyExistsException(String message) {
		super(message);
		this.message = message;
	}
	
}
