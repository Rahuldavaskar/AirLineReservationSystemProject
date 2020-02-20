package com.capgemini.airlinereservationsystem.dto;

public class ScheduleDetailsDto {
	static int flightId;
	private static String flightDay;
	private static String source;
	private static String destination;
	private static String departureTime;
	private static String arrivalTime;

	public static int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		ScheduleDetailsDto.flightId = flightId;
	}

	public static String getFlightDay() {
		return flightDay;
	}

	public void setFlightDay(String flightDay) {
		ScheduleDetailsDto.flightDay = flightDay;
	}

	public static String getSource() {
		return source;
	}

	public void setSource(String source) {
		ScheduleDetailsDto.source = source;
	}

	public static String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		ScheduleDetailsDto.destination = destination;
	}

	public static String getDepartureTime() {
		return departureTime;
	}

	public static void setDepartureTime(String departureTime) {
		ScheduleDetailsDto.departureTime = departureTime;
	}

	public static String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		ScheduleDetailsDto.arrivalTime = arrivalTime;
	}

}
