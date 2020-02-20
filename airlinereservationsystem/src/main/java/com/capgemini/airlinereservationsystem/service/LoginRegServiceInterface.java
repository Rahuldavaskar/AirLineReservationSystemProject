package com.capgemini.airlinereservationsystem.service;

public interface LoginRegServiceInterface {

	public boolean adminLoginService(String adminName, String password);

	public boolean userLoginService(String customerName, String password);

	public int userRegistrationService(int customerId, String customerName, String password, String dob,
			long phoneNumber, String email, String govtId, String gender, String nationality);

	public int adminRegistrationService(int adminId, String adminName, String password, String email, long phoneNumber);
}
