package com.capgemini.airlinereservationsystem.dto;

public class AddTicketDetailsBean {

	private static int ticketId;
	private static int flightId;
	private static double price;
	private static int totalTickets;
	private static String status;

	public static int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		AddTicketDetailsBean.ticketId = ticketId;
	}

	public static int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		AddTicketDetailsBean.flightId = flightId;
	}

	public static double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		AddTicketDetailsBean.price = price;
	}

	public static int getTotalTickets() {
		return totalTickets;
	}

	public void setTotalTickets(int totalTickets) {
		AddTicketDetailsBean.totalTickets = totalTickets;
	}

	public static String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		AddTicketDetailsBean.status = status;
	}
}
