package com.capgemini.airlinereservationsystem.service;

import java.util.List;

public interface UserServiceInterface {
	public List<Integer> ticketService(int flightId);

	public String ticketCancelService(int ticketId);

	public int adminFlightService(int flightId);

	public int deleteTicketDetails(int ticketId);

	public List<String> flightService(String source, String destination);

	public int confirmedTicketService(String source, String destination, int customerId);

	public String showConfirmedTicketService(int ticketId);
}