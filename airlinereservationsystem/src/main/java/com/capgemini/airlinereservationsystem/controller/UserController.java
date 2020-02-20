package com.capgemini.airlinereservationsystem.controller;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.airlinereservationsystem.exception.InvalidOptionException;
import com.capgemini.airlinereservationsystem.service.impl.UserServiceImplementation;

public class UserController {

	static Logger log = LogManager.getLogger("customer");

	public static void showFlightDetails() {

		try (Scanner scan = new Scanner(System.in)) {

			log.info("source: ");
			String source = scan.next();
			log.info("Destination: ");
			String destination = scan.next();

			UserServiceImplementation detailsServiceImpl = new UserServiceImplementation();
			List<String> res = detailsServiceImpl.flightService(source, destination);
			if (res != null) {
				log.info(res);
				UserMainController.userMain();
			} else {
				log.info("No data found");
				UserMainController.userMain();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

	public static void checkConfirmedTicket() {

		try (Scanner scan = new Scanner(System.in)) {

			log.info("source: ");
			String source = scan.next();
			log.info("Destination: ");
			String destination = scan.next();

			UserServiceImplementation detailsServiceImpl = new UserServiceImplementation();
			log.info(detailsServiceImpl.flightService(source, destination));

			log.info("Press 1 to confirm this flight");

			switch (scan.nextInt()) {
			case 1:
				log.info("Customer ID: ");
				int customer_id = scan.nextInt();
				UserServiceImplementation impl = new UserServiceImplementation();
				int res = impl.confirmedTicketService(source, destination, customer_id);
				if (res != 0) {
					log.info("Ticket Booked...");
					UserMainController.userMain();
				} else {
					log.info("Ticket not available check another flight");
					UserMainController.userMain();
				}
				break;

			default:
				try {
					UserMainController.userMain();
					throw new InvalidOptionException();
				} catch (InvalidOptionException e) {
					log.info(e.getMessage());
				}
				break;
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		}

	}

	public static void showTicketDetails() {

		try (Scanner sc = new Scanner(System.in)) {
			log.info("Ticket ID: ");
			int ticket_id = sc.nextInt();

			UserServiceImplementation impl = new UserServiceImplementation();
			String res = impl.showConfirmedTicketService(ticket_id);
			if (res != null) {
				log.info(res);
				UserMainController.userMain();
			} else {
				log.info("No record found");
			}

		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

	public static void cancelTicket() {

		try (Scanner scan = new Scanner(System.in)) {

			log.info("Please enter Ticket details\n");
			log.info("Ticket ID: ");
			int ticket_id = scan.nextInt();

			UserServiceImplementation impl = new UserServiceImplementation();
			String res = impl.ticketCancelService(ticket_id);

			if (res != null) {
				log.info(res);
				UserMainController.userMain();
			} else {
				log.info("No data found");
				UserMainController.userMain();
			}

		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

	public static void checkTicket() {

		try (Scanner scan = new Scanner(System.in)) {

			log.info("Please enter Ticket details\n");
			log.info("Ticket ID: ");
			int ticket_id = scan.nextInt();
			UserServiceImplementation impl = new UserServiceImplementation();
			List<Integer> res = impl.ticketService(ticket_id);

			if (res != null) {
				log.info(res);
				UserMainController.userMain();
			} else {
				log.info("No data found");
				UserMainController.userMain();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

}
