package com.capgemini.airlinereservationsystem.exception;

public class AdminNotFoundException extends RuntimeException{
	
	
	String msg="Enter valid id or password";


	
	public void AdminNotFoundExcepion() {
		
	}
	@Override
	public String getMessage() {
		return msg;
		
	}

}
