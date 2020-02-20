package com.capgemini.airlinereservationsystem.dto;

public class UserLoginBean {
	private static String customerName;

	public static String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		UserLoginBean.customerName = customerName;
	}
}
