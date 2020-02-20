package com.capgemini.airlinereservationsystem.exception;

public class InputMismatchException extends RuntimeException {
	String msg = "Please the valid Number";

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return msg;
	}

}
