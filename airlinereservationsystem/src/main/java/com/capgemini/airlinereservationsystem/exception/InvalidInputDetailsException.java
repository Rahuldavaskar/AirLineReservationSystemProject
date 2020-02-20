package com.capgemini.airlinereservationsystem.exception;

public class InvalidInputDetailsException extends RuntimeException {

	String msg = "Invalid details entered";

	public InvalidInputDetailsException() {
		
	}
	
	@Override
	public String getMessage() {
		return msg;
	}
}
