package com.capgemini.airlinereservationsystem.dto;

public class AdminRegistrationBean {

	private static int adminId;
	private static String adminName;
	private static String password;
	private static String email;
	private static long phoneNumber;

	public static int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		AdminRegistrationBean.adminId = adminId;
	}

	public static String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		AdminRegistrationBean.adminName = adminName;
	}

	public static String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		AdminRegistrationBean.password = password;
	}

	public static String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		AdminRegistrationBean.email = email;
	}

	public static long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhone_number(long phoneNumber) {
		AdminRegistrationBean.phoneNumber = phoneNumber;
	}

}
