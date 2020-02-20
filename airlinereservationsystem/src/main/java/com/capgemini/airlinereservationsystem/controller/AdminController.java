package com.capgemini.airlinereservationsystem.controller;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.airlinereservationsystem.exception.InvalidInputDetailsException;
import com.capgemini.airlinereservationsystem.exception.SomeThingWentWrongException;
import com.capgemini.airlinereservationsystem.factory.Factory;
import com.capgemini.airlinereservationsystem.service.AdminServiceInterface;
import com.capgemini.airlinereservationsystem.service.impl.UserServiceImplementation;

public class AdminController {

	static Logger log = new LogManager().getLogger("admin");

	public static void checkFlight() {

		try (Scanner scan = new Scanner(System.in)) {
			log.info("Please enter flight details\n");
			log.info("Flight ID: ");
			int flightId = scan.nextInt();
			log.info("Flight Name: ");
			String flightName = scan.next();
			log.info("Source: ");
			String source = scan.next();
			log.info("Destination: ");
			String destination = scan.next();
			log.info("Flight Date");
			String flightDate = scan.next();
			log.info("Arrival Time");
			String arrivalTime = scan.next();
			log.info("Departure Time");
			String departureTime = scan.next();

			AdminServiceInterface service = Factory.adminService();
			int res = service.flightService(flightId, flightName, source, destination, flightDate, arrivalTime, departureTime);

			if (res != 0) {
				log.info("Flight successfully added");
				AdminMainController.adminMain("Back");

			} else {
				log.info("oops.. check back with details");
				AdminController.checkFlight();
			}
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
	}

	public static void checkTicket() {

		try (Scanner sc = new Scanner(System.in)) {

			log.info("Enter ticket details");
			log.info("Ticket ID: ");
			int ticketId = sc.nextInt();
			log.info("Flight ID: ");
			int flightId = sc.nextInt();
			log.info("Price: ");
			double price = sc.nextDouble();
			log.info("Total Tickets: ");
			int totalTickets = sc.nextInt();
			log.info("Status: ");
			String status = sc.next();

			AdminServiceInterface service = Factory.adminService();
			int res = service.checkTicket(ticketId, flightId, price, totalTickets, status);
			if (res != 0) {
				log.info("Ticket details added successfully");
				AdminMainController.adminMain("Back");
			} else {
				log.info("oops...  check back with details");
				AdminController.checkTicket();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

	public static void checkPrice() {

		try (Scanner sc = new Scanner(System.in)) {

			log.info("Enter details to update");
			log.info("New Price: ");
			double newPrice = sc.nextDouble();
			log.info("Ticket ID: ");
			int ticketId = sc.nextInt();
			log.info("Flight ID: ");
			int flightId = sc.nextInt();

			AdminServiceInterface service = Factory.adminService();
			int res = service.changePrice(newPrice, ticketId, flightId);

			if (res != 0) {
				log.info("New Price updated successfully");
				AdminMainController.adminMain("Back");
			} else {
				log.info("oops... check back with details");
				AdminController.checkPrice();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

	public static void flightInfo() {

		log.info("Flight details\n");

		try {

			AdminServiceInterface service = Factory.adminService();
			List<String> result = service.flightInfo();

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < result.size(); i++) {
				sb.append(result.get(i) + "\t");
			}
			log.info(sb);
			AdminMainController.adminMain("Back");

		} catch (Exception e) {
			log.info(e.getMessage());
			AdminController.flightInfo();
		}
	}

	public static void cancelFlight() {

		try (Scanner sc = new Scanner(System.in)) {

			log.info("FlightId : ");
			int flight_id = sc.nextInt();
			UserServiceImplementation impl = new UserServiceImplementation();
			int res = impl.adminFlightService(flight_id);
			
			if(res != 0) {
				log.info("Flight deleted successfully");
				AdminMainController.adminMain("Back");
			} else {
				log.info("no record found");
				AdminMainController.adminMain("Back");
			}

		} catch (Exception e) {
			log.info(e.getMessage());
		}

	}

	public static void deleteTicket() {

		try (Scanner sc = new Scanner(System.in)) {

			log.info("TicketId :");
			int ticket_id = sc.nextInt();

			UserServiceImplementation impl = new UserServiceImplementation();
			int res = impl.deleteTicketDetails(ticket_id);
			if(res != 0) {
				log.info("Flight deleted successfully");
				AdminMainController.adminMain("Back");
			} else {
				log.info("no record found");
				AdminMainController.adminMain("Back");
			}
			AdminMainController.adminMain("Back");

		} catch (Exception e) {
			e.getMessage();
		}
	}
}