package com.capgemini.airlinereservationsystem.exception;

public class TicketNotFoundException extends RuntimeException{
	
	 String msg="TicketNotFound";
	
	public TicketNotFoundException() {
		
	}
	
	@Override
	public String getMessage() {
		return this.msg;
	}
}
