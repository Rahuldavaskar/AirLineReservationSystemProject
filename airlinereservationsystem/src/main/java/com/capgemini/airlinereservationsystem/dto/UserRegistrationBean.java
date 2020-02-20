package com.capgemini.airlinereservationsystem.dto;

import java.sql.Date;

public class UserRegistrationBean {
	private static int customerId;
	private static String customerName;
	private static String password;
	private static String dob;
	private static long phoneNumber;
	private static String email;
	private static String govtId;
	private static String gender;
	private static String nationality;

	public static int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public static String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public static String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public static String getDob() {
		return dob;
	}

	public static long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhone_number(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public static String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static String getGovtId() {
		return govtId;
	}

	public void setGovtId(String govtId2) {
		this.govtId = govtId2;
	}

	public static String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public static String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

}
