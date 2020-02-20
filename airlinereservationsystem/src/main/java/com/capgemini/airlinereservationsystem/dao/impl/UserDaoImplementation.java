package com.capgemini.airlinereservationsystem.dao.impl;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.airlinereservationsystem.dao.UserDaoInterface;
import com.capgemini.airlinereservationsystem.dto.ConfirmedTicketDetailsDto;
import com.capgemini.airlinereservationsystem.dto.FlightDetailsDto;
import com.capgemini.airlinereservationsystem.dto.TicketDetailsDto;
import com.capgemini.airlinereservationsystem.exception.DatabaseConnectivityException;

public class UserDaoImplementation implements UserDaoInterface {

	Properties pro = null;

	public UserDaoImplementation() {
		try {
			FileInputStream fis = new FileInputStream("db.properties");
			pro = new Properties();
			pro.load(fis);
			Class.forName(pro.getProperty("driver")).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Integer> ticketDetails() {

		try (Connection con = DriverManager.getConnection(pro.getProperty("dburl"));
				PreparedStatement pstmt = con.prepareStatement(pro.getProperty("tdquery"))) {

			pstmt.setInt(1, TicketDetailsDto.getFlightId());

			ResultSet rs = pstmt.executeQuery();
			List li = new ArrayList();
			while (rs.next()) {
				li.add(rs.getInt("ticket_id"));
				li.add(rs.getInt("total_tickets"));
			}
			return li;
		} catch (Exception e) {
			throw new DatabaseConnectivityException();
		}
	}

	@Override
	public String ticketCancelForm() {

		try (Connection con = DriverManager.getConnection(pro.getProperty("dburl"));
				//validate funtion/mthod
				//check if flght is presen in db ??
				PreparedStatement pstmt = con.prepareStatement(pro.getProperty("delquery"))) {

			pstmt.setInt(1, TicketDetailsDto.getTicketId());
			int count = pstmt.executeUpdate();
  
			return "Ticket cancellation successfully done";

		} catch (Exception e) {
			throw new DatabaseConnectivityException();
		}
	}

	@Override
	public int cancelFlightDetails() {

		try (Connection con = DriverManager.getConnection(pro.getProperty("dburl"));
				PreparedStatement pstmt = con.prepareStatement(pro.getProperty("cfdquery"))) {

			pstmt.setInt(1, FlightDetailsDto.getFlightId());
			int count = pstmt.executeUpdate();

			return count;

		} catch (Exception e) {
			throw new DatabaseConnectivityException();
		}
	}

	@Override
	public int ticketDelete() {

		try (Connection con = DriverManager.getConnection(pro.getProperty("dburl"));
				PreparedStatement pstmt = con.prepareStatement(pro.getProperty("tdelquery"))) {

			pstmt.setInt(1, TicketDetailsDto.getTicketId());
			int count = pstmt.executeUpdate();

			return count;

		} catch (Exception e) {
			throw new DatabaseConnectivityException();
		}
	}

	@Override
	public List flightDetails() {

		try (Connection con = DriverManager.getConnection(pro.getProperty("dburl"));
				PreparedStatement pstmt = con.prepareStatement(pro.getProperty("fdquery"))) {

			pstmt.setString(1, FlightDetailsDto.getSource());
			pstmt.setString(2, FlightDetailsDto.getDestination());

			ResultSet rs = pstmt.executeQuery();
			List al = new ArrayList();
			while (rs.next()) {

				al.add(rs.getInt("flight_id"));
				al.add(rs.getString("flight_name"));
				al.add(rs.getString("source"));
				al.add(rs.getString("destination"));
				al.add(rs.getTime("arrival_time"));
				al.add(rs.getTime("departure_time"));
				al.add(rs.getDate("flight_date"));
			}
			return al;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getConfirmTicketDetails() {

		try (Connection con = DriverManager.getConnection(pro.getProperty("dburl"));
				PreparedStatement pstmt = con.prepareStatement(pro.getProperty("incquery"))) {

			pstmt.setInt(1, ConfirmedTicketDetailsDto.getTicketId());
			pstmt.setInt(2, ConfirmedTicketDetailsDto.getCustomerId());
			pstmt.setDate(3, ConfirmedTicketDetailsDto.getFlightDate());
			pstmt.setInt(4, ConfirmedTicketDetailsDto.getFlightId());
			pstmt.setString(5, ConfirmedTicketDetailsDto.getFlightName());
			pstmt.setString(6, ConfirmedTicketDetailsDto.getSource());
			pstmt.setString(7, ConfirmedTicketDetailsDto.getDestination());
			pstmt.setTime(8, ConfirmedTicketDetailsDto.getArrivalTime());
			pstmt.setTime(9, ConfirmedTicketDetailsDto.getDepartureTime());
			pstmt.setString(10, ConfirmedTicketDetailsDto.getStatus());
			int count = pstmt.executeUpdate();

			return count;

		} catch (Exception e) {
			throw new DatabaseConnectivityException();
		}
	}

	@Override
	public String showConfirmTicketDetails() {

		try (Connection con = DriverManager.getConnection(pro.getProperty("dburl"));
				PreparedStatement pstmt = con.prepareStatement(pro.getProperty("slcquery"))) {

			pstmt.setInt(1, ConfirmedTicketDetailsDto.getTicketId());
			ResultSet rs = pstmt.executeQuery();
			String result = "";
			while (rs.next()) {

				result = result + "\n" + "ticket_id =" + rs.getInt("ticket_id") + "\n" + "customer_id ="
						+ rs.getInt("customer_id") + "\n" + "flight_date =" + rs.getDate("flight_date") + "\n"
						+ "flightId =" + rs.getString("flight_id") + "\n" + "flightName =" + rs.getString("flight_name")
						+ "\n" + "source =" + rs.getString("source") + "\n" + "destination ="
						+ rs.getString("destination") + "\n" + "arrival_time =" + rs.getString("arrival_time") + "\n"
						+ "departure_time =" + rs.getString("departure_time") + "\n" + "status ="
						+ rs.getString("status");

			}

			return result;

		} catch (Exception e) {
			throw new DatabaseConnectivityException();
		}
	}

}
