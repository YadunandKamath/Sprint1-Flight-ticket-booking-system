package com.capg.exceptions;

public class FlightAlreadyExistsException extends RuntimeException{
	
	private String message;

	public FlightAlreadyExistsException() {
		
	}

	public FlightAlreadyExistsException(String message) {
		super(message);
		this.message = message;
	}

}
