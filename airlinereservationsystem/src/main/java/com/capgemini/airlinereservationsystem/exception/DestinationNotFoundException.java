package com.capgemini.airlinereservationsystem.exception;

public class DestinationNotFoundException extends RuntimeException {
	
	String msg ="DestinationNotFoundException";
	
	public DestinationNotFoundException() {
		
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
	
}
