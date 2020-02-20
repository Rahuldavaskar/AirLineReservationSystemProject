package com.capgemini.airlinereservationsystem.dto;

import java.sql.Date;
import java.sql.Time;

public class FlightDetailsDto {

private static int flightId;
	private static String flightName;
	private static String source;
	private static String destination;
	private static String arrivalTime;
	private static String departureTime;

	public static int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		FlightDetailsDto.flightId = flightId;
	}

	public static String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		FlightDetailsDto.flightName = flightName;
	}

	public static String getSource() {
		return source;
	}

	public void setSource(String source) {
		FlightDetailsDto.source = source;
	}

	public static String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		FlightDetailsDto.destination = destination;
	}

	public static String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime2) {
		FlightDetailsDto.arrivalTime = arrivalTime2;
	}

	public static String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime2) {
		FlightDetailsDto.departureTime = departureTime2;
	}
}
