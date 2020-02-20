package com.capgemini.airlinereservationsystem.exception;

public class InvalidOptionException extends RuntimeException {

	String msg = "Please Enter valid option";

	public InvalidOptionException() {}
	
	@Override
	public String getMessage() {
		return this.msg;
	}
}
