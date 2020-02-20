package com.capgemini.airlinereservationsystem.service;

import java.util.List;

public interface AdminServiceInterface {

	public int checkTicket(int ticketId, int flightId, double price, int totalTickets, String status);
	
	public int changePrice(double newPrice, int ticketId, int flightId);
	
	public List<String> flightInfo();

	int flightService(int flightId, String flightName, String source, String flightDate, String destination,
			String arrivalTime, String departureTime);
}
