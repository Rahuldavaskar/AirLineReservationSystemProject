package com.capgemini.airlinereservationsystem.dao.impl;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.capgemini.airlinereservationsystem.dao.AdminDaoInterface;
import com.capgemini.airlinereservationsystem.dto.AddFlightDetailsBean;
import com.capgemini.airlinereservationsystem.dto.AddTicketDetailsBean;
import com.capgemini.airlinereservationsystem.dto.ChangeTicketPriceBean;
import com.capgemini.airlinereservationsystem.exception.DatabaseConnectivityException;

public class AdminDaoImplementation implements AdminDaoInterface {

	Properties pro = null;

	public AdminDaoImplementation() {
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
	public int addFlight() {

		try (Connection con = DriverManager.getConnection(pro.getProperty("dburl"));
				PreparedStatement pstmt = con.prepareStatement(pro.getProperty("afquery"))) {
			pstmt.setInt(1, AddFlightDetailsBean.getFlightId());
			pstmt.setString(2, AddFlightDetailsBean.getFlightName());
			pstmt.setString(3, AddFlightDetailsBean.getSource());
			pstmt.setString(4, AddFlightDetailsBean.getDestination());
			pstmt.setString(5, AddFlightDetailsBean.getFlightDate());
			pstmt.setString(6, AddFlightDetailsBean.getArrivalTime());
			pstmt.setString(7, AddFlightDetailsBean.getDepartureTime());

			int res = pstmt.executeUpdate();
			return res;
		} catch (Exception e) {
			throw new DatabaseConnectivityException();
		}
	}

	@Override
	public int addTicket() {
		int res = 0;

		try (Connection con = DriverManager.getConnection(pro.getProperty("dburl"));
				PreparedStatement pstmt = con.prepareStatement(pro.getProperty("atquery"))) {

			pstmt.setInt(1, AddTicketDetailsBean.getTicketId());
			pstmt.setInt(2, AddTicketDetailsBean.getFlightId());
			pstmt.setDouble(3, AddTicketDetailsBean.getPrice());
			pstmt.setInt(4, AddTicketDetailsBean.getTotalTickets());
			pstmt.setString(5, AddTicketDetailsBean.getStatus());

			res = pstmt.executeUpdate();

			return res;

		} catch (Exception e) {
			throw new DatabaseConnectivityException();
		}
	}

	@Override
	public int changeTicketPrice() {

		try (Connection con = DriverManager.getConnection(pro.getProperty("dburl"));
				PreparedStatement pstmt = con.prepareStatement(pro.getProperty("ctquery"))) {

			pstmt.setDouble(1, ChangeTicketPriceBean.getNewPrice());
			pstmt.setInt(2, ChangeTicketPriceBean.getTicketId());
			pstmt.setInt(3, ChangeTicketPriceBean.getFlight_id());

			int res = pstmt.executeUpdate();

			return res;

		} catch (Exception e) {
			throw new DatabaseConnectivityException();
		}
	}

	@Override
	public List<String> flightInfo() {
		List<String> flightInfo = new ArrayList<String>();

		try (Connection con = DriverManager.getConnection(pro.getProperty("dburl"));
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(pro.getProperty("finfoquery"))) {

			while (rs.next()) {

				flightInfo.add("Flight ID: "+rs.getString("flight_id")+"\t");
				flightInfo.add("Flight Name: "+rs.getString("flight_name")+"\t");
				flightInfo.add("Source: "+rs.getString("source")+"\t");
				flightInfo.add("Destination: "+rs.getString("destination")+"\t");
				flightInfo.add("Arrival Time: "+rs.getString("arrival_time")+"\t");
				flightInfo.add("Departure Time: "+rs.getString("departure_time")+"\t");
				flightInfo.add("\n");

			}
			return flightInfo;

		} catch (Exception e) {
			throw new DatabaseConnectivityException();
		}
	}
}