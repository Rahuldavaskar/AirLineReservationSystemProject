package com.capgemini.airlinereservationsystem.controller;

import java.util.ResourceBundle.Control;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.airlinereservationsystem.exception.InvalidOptionException;

public class AdminMainController {

	static Logger log = new LogManager().getLogger("admin");

	public static void adminMain(String adminName) {
		
		Scanner sc = new Scanner(System.in);
	
		log.info("\nWelcome  " + adminName+"\n");
		log.info("Please Enter 1 to add flight details");
		log.info("Please Enter 2 to add ticket details");
		log.info("Please Enter 3 to update ticket price");
		log.info("Please Enter 4 to show all flights info");
		log.info("Please Enter 5 to Delete Flight details");
		log.info("Please Enter 6 to Delete Ticket details");
		log.info("Please Enter 7 to Logout");

		int option = sc.nextInt();

		switch (option) {
		case 1:
			AdminController.checkFlight();
			break;
		case 2:
			AdminController.checkTicket();
			break;
		case 3:
			AdminController.checkPrice();
			break;
		case 4:
			AdminController.flightInfo();
			break;
		case 5:
			AdminController.cancelFlight();
			break;
		case 6:
			AdminController.deleteTicket();
			break;
		case 7:
			LoginRegController.adminlogincontroller();
			break;
		default:
			try {
				AdminMainController.adminMain(adminName);
				throw new InvalidOptionException();
			} catch (InvalidOptionException e) {
				log.info(e.getMessage());
			}
		    break;
		}
	}
}
