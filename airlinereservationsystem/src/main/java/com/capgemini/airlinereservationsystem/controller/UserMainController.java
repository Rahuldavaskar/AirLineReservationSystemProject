package com.capgemini.airlinereservationsystem.controller;

import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.airlinereservationsystem.exception.InvalidOptionException;

public class UserMainController {
	static Logger log = new LogManager().getLogger("user");

	public static void userMain() {
		Scanner sc = new Scanner(System.in);
		
		log.info("\nWelcome\n");
		
		log.info("Please Enter your choice");
		log.info("please Enter 1 to get Customer Details");
		log.info("Please Enter 2 to Book flight Ticket");
		log.info("please Enter 3 to get Schedule Details");
		log.info("please Enter 4 to get Journey Deatails");
		log.info("Please Enter 5 to Ticket Status");
		log.info("Please Enter 6 to Cancel Ticket");
		log.info("please Enter 7 to Logout");

		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			CustomerController.checkCustomer();

			break;
		case 2:
			UserController.checkConfirmedTicket();
			break;
		case 3:
			CustomerController.schedule();
			break;
		case 4:
			CustomerController.journey();
			break;
		case 5:
			UserController.checkTicket();
			break;
		case 6:
			UserController.cancelTicket();
			break;
		case 7:
			LoginRegController.customerlogincontroller();
			break;
		default:
			try {
				UserMainController.userMain();
				throw new InvalidOptionException();
			} catch (Exception e) {
				log.info(e.getMessage());
			}
			break;
		}
		sc.close();

	}
}
	

