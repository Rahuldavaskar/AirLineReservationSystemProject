package com.capgemini.airlinereservationsystem.dto;

public class CustomerDetailsDto {
	private static int customerId;

	public static int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		CustomerDetailsDto.customerId = customerId;
	}

}
