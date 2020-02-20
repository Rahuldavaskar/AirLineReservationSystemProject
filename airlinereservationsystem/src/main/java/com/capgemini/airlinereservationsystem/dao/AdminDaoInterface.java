package com.capgemini.airlinereservationsystem.dao;

import java.util.List;

public interface AdminDaoInterface {

	public int addFlight();
	public int addTicket();
	public int changeTicketPrice();
	public List<String> flightInfo();
}
