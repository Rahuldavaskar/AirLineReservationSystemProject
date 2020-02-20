package com.capgemini.airlinereservationsystem.service.impl;

import java.sql.Date;
import java.util.List;

import com.capgemini.airlinereservationsystem.dao.AdminDaoInterface;
import com.capgemini.airlinereservationsystem.dto.AddFlightDetailsBean;
import com.capgemini.airlinereservationsystem.dto.AddTicketDetailsBean;
import com.capgemini.airlinereservationsystem.dto.ChangeTicketPriceBean;
import com.capgemini.airlinereservationsystem.exception.DatabaseConnectivityException;
import com.capgemini.airlinereservationsystem.factory.Factory;
import com.capgemini.airlinereservationsystem.service.AdminServiceInterface;

public class AdminServiceImplementation implements AdminServiceInterface {

	@Override
	public int flightService(int flightId, String flightName, String source, String destination, String flightDate, String arrivalTime,
			String departureTime) {
		try {
			
			AddFlightDetailsBean add = new AddFlightDetailsBean();
			add.setFlightId(flightId);
			String fname = flightName.toLowerCase();
			add.setFlightName(fname);
			String src = source.toLowerCase();
			add.setSource(src);
			String dest = destination.toLowerCase();
			add.setDestination(dest);
			add.setFlightDate(flightDate);
			add.setArrivalTime(arrivalTime);
			add.setDepartureTime(departureTime);
			
			AdminDaoInterface factory = Factory.adminFactory();
			int res = factory.addFlight();
			return res;
		} catch (Exception e) {
			throw new DatabaseConnectivityException();
		}
	}

	@Override
	public int checkTicket(int ticketId, int flightId, double price, int totalTickets, String status) {
		try {
			
			AddTicketDetailsBean addTicket = new AddTicketDetailsBean();
			
			addTicket.setTicketId(ticketId);
			addTicket.setFlightId(flightId);
			addTicket.setPrice(price);
			addTicket.setTotalTickets(totalTickets);
			String stat = status.toLowerCase();
			addTicket.setStatus(stat);
			
			AdminDaoInterface factory = Factory.adminFactory();
			int res = factory.addTicket();
			return res;
		} catch (Exception e) {
			throw new DatabaseConnectivityException();
		}
	}

	@Override
	public int changePrice(double newPrice, int ticketId, int flightId) {
		try {
			ChangeTicketPriceBean change = new ChangeTicketPriceBean();
			change.setNewPrice(newPrice);
			change.setTicketId(ticketId);
			change.setFlight_id(flightId);
			
			AdminDaoInterface factory = Factory.adminFactory();
			int res = factory.changeTicketPrice();
			return res;
			
		} catch (Exception e) {
			throw new DatabaseConnectivityException();
		}
	}

	@Override
	public List<String> flightInfo() {
		try {
			AdminDaoInterface factory = Factory.adminFactory();
			List<String> result = factory.flightInfo();
			return result;
			
		} catch (Exception e) {
			throw new DatabaseConnectivityException();
		}
	}

}
