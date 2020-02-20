package com.capgemini.airlinereservationsystem;

import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.airlinereservationsystem.controller.LoginRegController;
import com.capgemini.airlinereservationsystem.controller.UserController;
import com.capgemini.airlinereservationsystem.exception.InvalidOptionException;

public class Home {

	static Logger log = LogManager.getLogger("admin");

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		log.info("\n\n==================================");
		log.info("Welcome to Airlines Reservation System...");
		log.info("==================================");
		log.info("\n--------------Menu---------------\n");
		log.info("Please Enter 1 to SignIn");
		log.info("Please Enter 2 to SignUp");
		log.info("Please Enter 3 to Check Flights");
		log.info("Please Enter 4 to Contact us");

		int option = scan.nextInt();

		switch (option) {
		case 1:
			log.info("\n----------Login----------\n");
			log.info("Enter 1 to User Login");
			log.info("Enter 2 to Admin Login");
			log.info("Enter 3 to Home");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				LoginRegController.customerlogincontroller();
				break;
			case 2:
				LoginRegController.adminlogincontroller();
				break;
			case 3:
				new Home().main(null);
				break;

			default:
				try {
					throw new InvalidOptionException();
				} catch (InvalidOptionException e) {
					log.info(e.getMessage());
					new Home();
				}
				break;
			}
			break;
		case 2:
			log.info("\n----------Registration----------\n");
			log.info("Enter 1 to User Registration");
			log.info("Enter 2 to Admin Registration");
			log.info("Enter 3 to Home");
			int reg = scan.nextInt();

			switch (reg) {
			case 1:
				LoginRegController.userregistrationcontroller();
				break;
			case 2:
				LoginRegController.adminregistrationcontroller();
				break;
			case 3:
				new Home().main(null);
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
			break;
		case 3:
			try {
				UserController.showFlightDetails();
			} catch (InvalidOptionException e) {
				log.info(e.getMessage());
				UserController.showFlightDetails();
			}
			break;
		case 4:
			log.info("\n----- Contact US -------\n");
			log.info("\nRahul\nSamruddhi\nVinay\nKetki");
			log.info("Address: QSpiders Basavanagudi");
			new Home().main(null);
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
}