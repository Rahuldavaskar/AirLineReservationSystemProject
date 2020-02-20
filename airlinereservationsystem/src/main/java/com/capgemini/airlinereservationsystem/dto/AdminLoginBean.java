package com.capgemini.airlinereservationsystem.dto;

public class AdminLoginBean {

	private static String adminName;

	public static String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		AdminLoginBean.adminName = adminName;
	}

}
