package com.capgemini.airlinereservationsystem.service;

public interface CustomerServiceInterface {

	public String searchForm(int customerId);
	public String journeyDetails(int flightId);
	public String scheduleFlight(int flightId);
}
