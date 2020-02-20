package com.capgemini.airlinereservationsystem.exception;

public class SomeThingWentWrongException extends RuntimeException {

	String msg = "Something went wrong check back again..";

	public SomeThingWentWrongException() {
		super();
	}

	@Override
	public String getMessage() {
		return this.msg;
	}
}
