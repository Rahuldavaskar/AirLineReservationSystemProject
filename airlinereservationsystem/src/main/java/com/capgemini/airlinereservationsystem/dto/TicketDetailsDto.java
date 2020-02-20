package com.capgemini.airlinereservationsystem.dto;

public class TicketDetailsDto {
	private static int ticketId;
	private static int flightId;
	private static double price;
	private static int totalTickets;
	private static String status;

	public static int getTicketId() {
		return ticketId;
	}

	public  void setTicketId(int ticketId) {
		TicketDetailsDto.ticketId = ticketId;
	}

	public static int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		TicketDetailsDto.flightId = flightId;
	}

	public static double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		TicketDetailsDto.price = price;
	}

	public static int getTotalTickets() {
		return totalTickets;
	}

	public void setTotalTickets(int totalTickets) {
		TicketDetailsDto.totalTickets = totalTickets;
	}

	public static String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		TicketDetailsDto.status = status;
	}

}
