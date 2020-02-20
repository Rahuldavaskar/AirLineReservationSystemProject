package com.capgemini.airlinereservationsystem.controller;

import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.airlinereservationsystem.Home;
import com.capgemini.airlinereservationsystem.exception.InvalidInputDetailsException;
import com.capgemini.airlinereservationsystem.exception.InvalidOptionException;
import com.capgemini.airlinereservationsystem.exception.LoginFailedException;
import com.capgemini.airlinereservationsystem.exception.UserNotFoundException;
import com.capgemini.airlinereservationsystem.service.LoginRegServiceInterface;
import com.capgemini.airlinereservationsystem.service.impl.LoginRegServiceImplementation;

public class LoginRegController {

	static Logger log = new LogManager().getLogger("admin");

	public static void adminlogincontroller() {
		Scanner scan = new Scanner(System.in);
		

		try {
			log.info("\n==========Admin Login=========");
			log.info("\nPlease Enter Login Credentials\n");
			log.info("User Name");
			String adminName = scan.next();
			log.info("Password");
			String password = scan.next();
			
			LoginRegServiceInterface login = new LoginRegServiceImplementation();
			boolean res = login.adminLoginService(adminName, password);
			if (res == true) {
				log.info("Login success");
				AdminMainController.adminMain(adminName);
			} else {
				log.info("Login failed");
				log.info("Enter 1 Login again");
				log.info("Enter 2 to Home");
				int key = scan.nextInt();
				switch (key) {
				case 1:
					LoginRegController.adminregistrationcontroller();
					break;
				case 2:
					new Home().main(null);
					;
					break;
				default:
					try {
						throw new InvalidOptionException();
					} catch (InvalidOptionException e) {
						log.info(e.getMessage());
						new Home().main(null);
					}
					break;
				}
			}

		} catch (LoginFailedException ae) {
			log.info(ae.getMessage());
		}
	}

	public static void customerlogincontroller() {
		Scanner scan = new Scanner(System.in);

		try {
			log.info("\n===========User Login===========\n");
			log.info("\nPlease Enter Login Credentials\n");
			log.info("Customer Name");
			String customerName = scan.next();
			log.info("Password");
			String password = scan.next();
			LoginRegServiceImplementation login = new LoginRegServiceImplementation();
			boolean res = login.userLoginService(customerName, password);
			if (res == true) {
				log.info("Login success");
				UserMainController.userMain();
			} else {
				log.info("Login failed");
				log.info("Enter 1 Login again");
				log.info("Enter 2 to Home");
				int key = scan.nextInt();
				switch (key) {
				case 1:
					LoginRegController.customerlogincontroller();
					break;
				case 2:
					new Home().main(null);
					;
					break;
				default:
					try {
						throw new InvalidOptionException();
					} catch (InvalidOptionException e) {
						log.info(e.getMessage());
						new Home().main(null);
					}
					break;
				}
			}
		} catch (LoginFailedException ae) {
			log.info(ae.getMessage());
		}
	}

	public static void userregistrationcontroller() {

		try {
			
			Scanner scan = new Scanner(System.in);
			log.info("/n---------Customer Registration------/n");
			log.info("\nPlease Enter details\n");
			log.info("Customer ID: ");
			int customerId = scan.nextInt();
			log.info("Customer Name: ");
			String customerName = scan.next();
			log.info("Password: ");
			String password = scan.next();
			log.info("Date Of Birth: ");
			String dob = scan.next();
			log.info("Phone Number: ");
			long phoneNumber = scan.nextLong();
			log.info("Email: ");
			String email = scan.next();
			log.info("Govnment ID: ");
			String govtId = scan.next();
			log.info("Gender: ");
			String gender = scan.next();
			log.info("Nationality: ");
			String nationality = scan.next();
			
			LoginRegServiceInterface reg = new LoginRegServiceImplementation();
			int res = reg.userRegistrationService(customerId, customerName, password, dob, phoneNumber, email, govtId,
					gender, nationality);
			
			if (res != 0) {
				log.info("Registration successfull");
			} else {
				try {
					LoginRegController.customerlogincontroller();
					throw new InvalidInputDetailsException();
				} catch (InvalidInputDetailsException e) {
					log.info(e.getMessage());
				}
			}
		} catch (InvalidInputDetailsException e) {
			log.info(e.getMessage());
		}

	}

	public static void adminregistrationcontroller() {
		try {
			
			Scanner scan = new Scanner(System.in);
			log.info("Admin ID: ");
			int adminId = scan.nextInt();
			log.info("Admin Name: ");
			String adminName = scan.next();
			log.info("Password: ");
			String password = scan.next();
			log.info("Email: ");
			String email = scan.next();
			log.info("Phone Number: ");
			long phoneNumber = scan.nextLong();
			
			LoginRegServiceInterface reg = new LoginRegServiceImplementation();
			try {
				int res = reg.adminRegistrationService(adminId, adminName, password, email, phoneNumber);
				
				
				if (res != 0) {
					log.info("Registration successfull");
				} else {
					try {
						LoginRegController.adminlogincontroller();
						throw new InvalidInputDetailsException();
					} catch (InvalidInputDetailsException e) {
						log.info(e.getMessage());
					}
				}
			} catch (InvalidInputDetailsException e) {
				log.info(e.getMessage());
			}
		} catch (InvalidInputDetailsException e) {
			log.info(e.getMessage());
		}
	}
}
