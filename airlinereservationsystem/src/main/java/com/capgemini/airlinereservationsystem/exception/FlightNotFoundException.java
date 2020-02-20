package com.capgemini.airlinereservationsystem.exception;

public class FlightNotFoundException extends RuntimeException{
	
	String msg="FlightNotFoundException";
	
	
	public FlightNotFoundException() {
		
	}
	@Override
	public String getMessage() {

		return super.getMessage();
	}
	
	
}
