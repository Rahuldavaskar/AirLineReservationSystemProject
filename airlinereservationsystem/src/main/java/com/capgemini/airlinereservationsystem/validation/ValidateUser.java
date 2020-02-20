package com.capgemini.airlinereservationsystem.validation;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import com.capgemini.airlinereservationsystem.dao.LoginRegDaoInterface;
import com.capgemini.airlinereservationsystem.dao.impl.LoginRegDaoImplementation;
import com.capgemini.airlinereservationsystem.exception.LoginFailedException;

public class ValidateUser {

	public static boolean passwordValidator(String inputCustomerName, String inputCustomerPassword)
			throws LoginFailedException {

		boolean status = false;
		try {

			LoginRegDaoInterface login = new LoginRegDaoImplementation();
			List<String> login1 = login.userlogin();
			String customerName = login1.get(0);
			String password = login1.get(1);

			if (inputCustomerName.equals(customerName)) {
				if (BCrypt.checkpw(inputCustomerPassword, password)) {
					status = true;
				} else {
					status = false;
				}
			} else {
				status = false;
			}
			return status;
		} catch (LoginFailedException e) {
			throw new LoginFailedException();
		}
	}
}
