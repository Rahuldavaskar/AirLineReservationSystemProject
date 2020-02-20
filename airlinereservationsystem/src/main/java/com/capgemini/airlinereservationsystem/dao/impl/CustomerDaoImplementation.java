
package com.capgemini.airlinereservationsystem.dao.impl;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import com.capgemini.airlinereservationsystem.dao.CustomerDaoInterface;
import com.capgemini.airlinereservationsystem.dto.CustomerDetailsDto;
import com.capgemini.airlinereservationsystem.dto.JourneyDetailsDto;
import com.capgemini.airlinereservationsystem.dto.ScheduleDetailsDto;
import com.capgemini.airlinereservationsystem.exception.DatabaseConnectivityException;

public class CustomerDaoImplementation implements CustomerDaoInterface {

	Properties pro = null;

	public CustomerDaoImplementation() {
		try {
			FileInputStream fis = new FileInputStream("db.properties");
			pro = new Properties();
			pro.load(fis);
			Class.forName(pro.getProperty("driver")).newInstance();
		} catch (Exception e) {
			throw new DatabaseConnectivityException();
		}
	}

	@Override
	public String searchForm() {

		try (Connection con = DriverManager.getConnection(pro.getProperty("dburl"));
				PreparedStatement pstmt = con.prepareStatement(pro.getProperty("sfquery"));
				) {

			pstmt.setInt(1, CustomerDetailsDto.getCustomerId());
			ResultSet rs = pstmt.executeQuery();
			String result = " ";
			while (rs.next()) {

				result = result + "\n" + "customerId =" + rs.getInt("customer_id") + "\n" 
						 + rs.getString("customer_name") + "\t\t"
						+ rs.getString("password") + "\t\t" + rs.getLong("phone_number") + "\t\t"
						+ rs.getString("email") + "\t\t" + rs.getString("govt_id") + "\t\t" + rs.getString("gender")
						+ "\t\t" + rs.getString("nationality");

			}
			return result;

		} catch (Exception e) {
			throw new DatabaseConnectivityException();
		}
	}

	@Override
	public String journeyDetails() {

		try (Connection con = DriverManager.getConnection(pro.getProperty("dburl"));
				PreparedStatement pstmt = con.prepareStatement(pro.getProperty("jdquery"));
				) {

			pstmt.setInt(1, JourneyDetailsDto.getFlightId());
			ResultSet rs = pstmt.executeQuery();
			String result = "";
			while (rs.next()) {

				result = result + "\n" + rs.getInt("flight_id") + "\n" + "Source " + "\t\t" + "\t\t" + "Destination "
						+ "\t\t" + "ArrivalTime" + "\t\t" + "DepartureTime" + "\n" + "\t\t" + rs.getString("source")
						+ "\t\t" + rs.getString("destination") + "\t\t" + rs.getString("arrival_time") + "\t\t"
						+ rs.getString("departure_time");

			}

			return result;
		} catch (Exception e) {
			throw new DatabaseConnectivityException();
		}
	}

	@Override
	public String scheduleFlight() {

		try (Connection con = DriverManager.getConnection(pro.getProperty("dburl"));
				PreparedStatement pstmt = con.prepareStatement(pro.getProperty("sdfquery"));
				) {

			pstmt.setInt(1, ScheduleDetailsDto.getFlightId());
			ResultSet rs = pstmt.executeQuery();
			String result = "";
			while (rs.next()) {

				result = result + "\n" + "flightId= " + rs.getInt("flight_id") + "\n" + "Arrivaltime " + "\t\t"
						+ "DepartureTime " + "\n" + rs.getString("arrival_time") + "\t\t"
						+ rs.getTime("departure_time");
			}
			System.out.println(result);
			return result;
		} catch (Exception e) {
			throw new DatabaseConnectivityException();
		}
	}
}
