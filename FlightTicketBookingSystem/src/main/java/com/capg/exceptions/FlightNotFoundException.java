package com.capg.exceptions;

public class FlightNotFoundException extends RuntimeException{
	
	private String message;
	
	public FlightNotFoundException() {
		
	}
	
	public FlightNotFoundException(String message) {
		super(message);
		this.message=message;
	}
	
}
