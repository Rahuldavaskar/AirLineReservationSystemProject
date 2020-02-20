package com.capgemini.airlinereservationsystem.dto;

import java.sql.Date;
import java.sql.Time;

public class ConfirmedTicketDetailsDto {

	private static int ticketId;
	private static int customerId;
	private static int flightId;
	private static String flightName;
	private static String source;
	private static String destination;
	private static Time arrivalTime;
	private static Time departureTime;
	private static String status;
	private static Date flightDate;

	public static int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		ConfirmedTicketDetailsDto.ticketId = ticketId;
	}

	public static int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		ConfirmedTicketDetailsDto.customerId = customerId;
	}

	public static int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		ConfirmedTicketDetailsDto.flightId = flightId;
	}

	public static String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		ConfirmedTicketDetailsDto.flightName = flightName;
	}

	public static String getSource() {
		return source;
	}

	public void setSource(String source) {
		ConfirmedTicketDetailsDto.source = source;
	}

	public static String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		ConfirmedTicketDetailsDto.destination = destination;
	}

	public static Time getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Time arrTime) {
		ConfirmedTicketDetailsDto.arrivalTime = arrTime;
	}

	public static Time getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Time depart) {
		ConfirmedTicketDetailsDto.departureTime = depart;
	}

	public static String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		ConfirmedTicketDetailsDto.status = status;
	}

	public static Date getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(Date flightDate) {
		ConfirmedTicketDetailsDto.flightDate = flightDate;
	}
}
