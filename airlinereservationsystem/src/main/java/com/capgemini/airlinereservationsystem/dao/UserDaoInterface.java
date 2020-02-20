package com.capgemini.airlinereservationsystem.dao;

import java.util.List;

public interface UserDaoInterface {
	List<Integer> ticketDetails();

	public String ticketCancelForm();

	public int cancelFlightDetails();

	public int ticketDelete();

	public List<String> flightDetails();

	public int getConfirmTicketDetails();

	public String showConfirmTicketDetails();
}
