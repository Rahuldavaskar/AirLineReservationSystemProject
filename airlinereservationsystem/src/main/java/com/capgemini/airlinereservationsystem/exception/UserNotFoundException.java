package com.capgemini.airlinereservationsystem.exception;

public class UserNotFoundException extends RuntimeException {
	String msg="Enter valid id or password";
	public void UserNotFoundException() {
		
	}
	@Override
	public String getMessage() {
		return msg;

}
}
