package com.capgemini.airlinereservationsystem.dto;

public class ChangeTicketPriceBean {

	private static double newPrice;
	private static int ticketId;
	private static int flight_id;

	public static double getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(double newPrice) {
		ChangeTicketPriceBean.newPrice = newPrice;
	}

	public static int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		ChangeTicketPriceBean.ticketId = ticketId;
	}

	public static int getFlight_id() {
		return flight_id;
	}

	public void setFlight_id(int flight_id) {
		ChangeTicketPriceBean.flight_id = flight_id;
	}
}
