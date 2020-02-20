package com.capgemini.airlinereservationsystem.exception;

public class LoginFailedException extends RuntimeException {

	String msg = "Login Failed";

	public LoginFailedException() {
		super();
	}
	
	@Override
	public String getMessage() {
		return this.msg;
	}
}
