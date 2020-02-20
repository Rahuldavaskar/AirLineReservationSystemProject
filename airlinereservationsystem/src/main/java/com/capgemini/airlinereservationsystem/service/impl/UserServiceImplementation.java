package com.capgemini.airlinereservationsystem.service.impl;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.capgemini.airlinereservationsystem.dao.UserDaoInterface;
import com.capgemini.airlinereservationsystem.dao.impl.UserDaoImplementation;
import com.capgemini.airlinereservationsystem.dto.ConfirmedTicketDetailsDto;
import com.capgemini.airlinereservationsystem.dto.FlightDetailsDto;
import com.capgemini.airlinereservationsystem.dto.TicketDetailsDto;
import com.capgemini.airlinereservationsystem.exception.DatabaseConnectivityException;
import com.capgemini.airlinereservationsystem.service.UserServiceInterface;

public class UserServiceImplementation implements UserServiceInterface {

	@Override
	public List<Integer> ticketService(int flightId) {
		try {

			TicketDetailsDto td = new TicketDetailsDto();
			td.setFlightId(flightId);

			UserDaoInterface daoImpl = new UserDaoImplementation();
			List<Integer> ticdao = daoImpl.ticketDetails();
			return ticdao;
		} catch (Exception e) {
			throw new DatabaseConnectivityException();
		}
	}

	@Override
	public String ticketCancelService(int ticketId) {

		try {

			TicketDetailsDto tdd = new TicketDetailsDto();
			tdd.setTicketId(ticketId);

			UserDaoImplementation daoImpl = new UserDaoImplementation();
			return daoImpl.ticketCancelForm();
		} catch (Exception e) {
			throw new DatabaseConnectivityException();
		}
	}

	@Override
	public int adminFlightService(int flightId) {

		try {

			FlightDetailsDto dto = new FlightDetailsDto();
			dto.setFlightId(flightId);

			UserDaoImplementation daoimpl = new UserDaoImplementation();
			return daoimpl.cancelFlightDetails();
		} catch (Exception e) {
			throw new DatabaseConnectivityException();
		}

	}

	@Override
	public int deleteTicketDetails(int ticketId) {

		try {

			TicketDetailsDto dto = new TicketDetailsDto();
			dto.setTicketId(ticketId);

			UserDaoImplementation daoimpl = new UserDaoImplementation();
			return daoimpl.ticketDelete();
		} catch (Exception e) {
			throw new DatabaseConnectivityException();
		}

	}

	@Override
	public List<String> flightService(String source, String destination) {

		try {

			FlightDetailsDto dto = new FlightDetailsDto();
			dto.setSource(source);
			dto.setDestination(destination);

			UserDaoImplementation daoimpl = new UserDaoImplementation();
			List<String> list =  daoimpl.flightDetails();
			return list;
		} catch (Exception e) {
			throw new DatabaseConnectivityException();
		}
	}

	@Override
	public int confirmedTicketService(String source, String destination, int customerId) {

		try {

			UserServiceImplementation service = new UserServiceImplementation();
			List flight = service.flightService(source, destination);
			int flightId = (int) flight.get(0);
			String flightName = (String) flight.get(1);
			Time arrTime = (Time) flight.get(4);
			Time depart = (Time) flight.get(5);
			Date date1 = (Date) flight.get(6);
			UserServiceImplementation tserv = new UserServiceImplementation();
			List<Integer> tic = tserv.ticketService(flightId);
			int ticketId = tic.get(0);
			int totalTicket = tic.get(1);

			if (totalTicket > 0) {
				ConfirmedTicketDetailsDto confirm = new ConfirmedTicketDetailsDto();
				confirm.setCustomerId(customerId);
				confirm.setFlightId(flightId);
				confirm.setTicketId(ticketId);
				confirm.setFlightDate(date1);
				confirm.setFlightName(flightName);
				confirm.setSource(source);
				confirm.setDestination(destination);
				confirm.setArrivalTime(arrTime);
				confirm.setDepartureTime(depart);
				confirm.setStatus("confirmed");

				UserDaoImplementation confirmTicket = new UserDaoImplementation();
				int res = confirmTicket.getConfirmTicketDetails();
				return res;
			}
		} catch (Exception e) {
			throw new DatabaseConnectivityException();
		}
		return 0;
	}

	@Override
	public String showConfirmedTicketService(int ticketId) {

		try {
			
			ConfirmedTicketDetailsDto dto = new ConfirmedTicketDetailsDto();
			dto.setTicketId(ticketId);
			
			UserDaoImplementation dao = new UserDaoImplementation();
			return dao.showConfirmTicketDetails();
		} catch (Exception e) {
			throw new DatabaseConnectivityException();
		}

	}
}
