package com.capgemini.airlinereservationsystem.service.impl;

import com.capgemini.airlinereservationsystem.dao.CustomerDaoInterface;
import com.capgemini.airlinereservationsystem.dao.impl.CustomerDaoImplementation;
import com.capgemini.airlinereservationsystem.dto.CustomerDetailsDto;
import com.capgemini.airlinereservationsystem.dto.JourneyDetailsDto;
import com.capgemini.airlinereservationsystem.dto.ScheduleDetailsDto;
import com.capgemini.airlinereservationsystem.exception.DatabaseConnectivityException;
import com.capgemini.airlinereservationsystem.factory.Factory;
import com.capgemini.airlinereservationsystem.service.CustomerServiceInterface;

public class CustomerServiceImplementation implements CustomerServiceInterface {

	@Override
	public String searchForm(int customerId) {
		try {
			CustomerDetailsDto add = new CustomerDetailsDto();
			add.setCustomerId(customerId);

			CustomerDaoInterface cdd = Factory.customerFactory();
			String res = cdd.searchForm();
			return cdd.searchForm();

		} catch (Exception e) {
			throw new DatabaseConnectivityException();
		}

	}

	@Override
	public String journeyDetails(int flightId) {
		try {
			JourneyDetailsDto add = new JourneyDetailsDto();
			add.setFlightId(flightId);

			CustomerDaoInterface jddi = Factory.customerFactory();
			String res = jddi.journeyDetails();
			return res;
		} catch (Exception e) {
			throw new DatabaseConnectivityException();
		}
	}

	@Override
	public String scheduleFlight(int flightId) {
		try {

			ScheduleDetailsDto add = new ScheduleDetailsDto();
			add.setFlightId(flightId);

			CustomerDaoInterface daoImpl = Factory.customerFactory();
			String res = daoImpl.scheduleFlight();
			return res;
		} catch (Exception e) {
			throw new DatabaseConnectivityException();
		}
	}
}
