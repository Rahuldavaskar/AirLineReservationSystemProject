package com.capgemini.airlinereservationsystem.dto;

import java.sql.Date;

public class AddFlightDetailsBean {

	private static int flightId;
	private static String flightName;
	private static String source;
	private static String destination;
	private static String flightDate;
	private static String arrivalTime;
	private static String departureTime;

	public static int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		AddFlightDetailsBean.flightId = flightId;
	}

	public static String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		AddFlightDetailsBean.flightName = flightName;
	}

	public static String getSource() {
		return source;
	}

	public void setSource(String source) {
		AddFlightDetailsBean.source = source;
	}

	public static String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		AddFlightDetailsBean.destination = destination;
	}

	public static String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime2) {
		AddFlightDetailsBean.arrivalTime = arrivalTime2;
	}

	public static String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime2) {
		AddFlightDetailsBean.departureTime = departureTime2;
	}

	public static String getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(String date) {
		AddFlightDetailsBean.flightDate = date;
	}
}