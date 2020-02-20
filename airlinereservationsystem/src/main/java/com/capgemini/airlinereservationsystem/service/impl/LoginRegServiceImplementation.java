package com.capgemini.airlinereservationsystem.service.impl;

import com.capgemini.airlinereservationsystem.dao.LoginRegDaoInterface;
import com.capgemini.airlinereservationsystem.dao.impl.LoginRegDaoImplementation;
import com.capgemini.airlinereservationsystem.dto.AdminLoginBean;
import com.capgemini.airlinereservationsystem.dto.AdminRegistrationBean;
import com.capgemini.airlinereservationsystem.dto.UserLoginBean;
import com.capgemini.airlinereservationsystem.dto.UserRegistrationBean;
import com.capgemini.airlinereservationsystem.exception.DatabaseConnectivityException;
import com.capgemini.airlinereservationsystem.exception.LoginFailedException;
import com.capgemini.airlinereservationsystem.service.LoginRegServiceInterface;
import com.capgemini.airlinereservationsystem.validation.PasswordEncoder;
import com.capgemini.airlinereservationsystem.validation.ValidateCreditional;
import com.capgemini.airlinereservationsystem.validation.ValidateUser;

public class LoginRegServiceImplementation implements LoginRegServiceInterface {

	@Override
	public boolean adminLoginService(String adminName, String password) {

		AdminLoginBean registration = new AdminLoginBean();

		String adminname = adminName.toLowerCase();
		registration.setAdminName(adminname);

		try {
			boolean res = ValidateCreditional.passwordValidator(adminname, password);

			return res;
		} catch (LoginFailedException e) {
			throw new LoginFailedException();
		}
	}

	@Override
	public boolean userLoginService(String customerName, String password) {
		
		try {
			
			UserLoginBean login = new UserLoginBean();
			String customername = customerName.toLowerCase();
			login.setCustomerName(customername);
			
			boolean res = ValidateUser.passwordValidator(customerName, password);
			return res;
		} catch (Exception e) {
			throw new LoginFailedException();
		}

	}

	@Override
	public int userRegistrationService(int customerId, String customerName, String password, String dob,
			long phoneNumber, String email, String govtId, String gender, String nationality) {
		try {
			
			UserRegistrationBean registration = new UserRegistrationBean();
			registration.setCustomerId(customerId);
			
			registration.setCustomerName(customerName);
			String enPassword = PasswordEncoder.passwordEncoder(password);
			registration.setPassword(enPassword);
			registration.setDob(dob);
			registration.setPhone_number(phoneNumber);
			registration.setEmail(email);
			registration.setGovtId(govtId);
			registration.setGender(gender);
			registration.setNationality(nationality);
			
			LoginRegDaoInterface register = new LoginRegDaoImplementation();
			int res = register.userRegistration();
			return res;
		} catch (Exception e) {
			throw new DatabaseConnectivityException();
		}
	}

	@Override
	public int adminRegistrationService(int adminId, String adminName, String password, String email,
			long phoneNumber) {
		try {
			AdminRegistrationBean registration=new AdminRegistrationBean();
			registration.setAdminId(adminId);
			registration.setAdminName(adminName);
			String enPassword = PasswordEncoder.passwordEncoder(password);
			registration.setPassword(enPassword);
			registration.setEmail(email);
			registration.setPhone_number(phoneNumber);
			
			LoginRegDaoInterface register = new LoginRegDaoImplementation();
			int res = register.adminRegistration();
			return res;
			
		} catch (Exception e) {
			throw new DatabaseConnectivityException();
		}
	}

}
