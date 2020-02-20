package com.capgemini.airlinereservationsystem.dto;

public class JourneyDetailsDto {
	private static int flightId;

	public static int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		JourneyDetailsDto.flightId = flightId;
	}

}
