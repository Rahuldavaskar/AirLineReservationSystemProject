package com.capgemini.airlinereservationsystem.controller;

import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.airlinereservationsystem.exception.InvalidOptionException;
import com.capgemini.airlinereservationsystem.factory.Factory;
import com.capgemini.airlinereservationsystem.service.CustomerServiceInterface;
import com.capgemini.airlinereservationsystem.service.impl.CustomerServiceImplementation;

public class CustomerController {

	static Logger log = new LogManager().getLogger("user");

	public static void checkCustomer() {
		Scanner scan = new Scanner(System.in);

		log.info("please enter customerId:");

		try {
			int customerId = scan.nextInt();
			CustomerServiceInterface service = Factory.customerService();
			String res = service.searchForm(customerId);
			log.info(res);
			UserMainController.userMain();
		} catch (InvalidOptionException e) {
			log.info(e.getMessage());
			CustomerController.checkCustomer();
		}
	}

	public static void schedule() {

		Scanner scan = new Scanner(System.in);

		log.info("Please enter below details\n");
		log.info("Flight ID: ");
		int flightId = scan.nextInt();

		CustomerServiceInterface service = new CustomerServiceImplementation();
		String result = service.scheduleFlight(flightId);
		log.info(result);
		if (result != null) {
			System.out.println("Have Happy and Safe Journey..!!!!");
			UserMainController.userMain();
		} else {
			System.out.println("oops.. check back with details");
			CustomerController.schedule();
		}
	}
	
	public static void journey() {
		
		try (Scanner sc = new Scanner(System.in)) {

			log.info("Please Enter FlightId ");
			int flightId = sc.nextInt();
			CustomerServiceInterface service = new CustomerServiceImplementation();
			String result = service.journeyDetails(flightId);
			log.info(result);
			if (result != null) {
				log.info("Have Happy And Safe Journey..!!!!");
				UserMainController.userMain();
			} else {
				log.info("Please Enter Valid FlightId");
				CustomerController.journey();
			}
		} catch (InvalidOptionException e) {
			log.info(e.getMessage());
		}

	}

}
