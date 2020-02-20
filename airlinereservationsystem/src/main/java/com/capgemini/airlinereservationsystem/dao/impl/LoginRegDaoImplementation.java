package com.capgemini.airlinereservationsystem.dao.impl;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.capgemini.airlinereservationsystem.dao.LoginRegDaoInterface;
import com.capgemini.airlinereservationsystem.dto.AdminLoginBean;
import com.capgemini.airlinereservationsystem.dto.AdminRegistrationBean;
import com.capgemini.airlinereservationsystem.dto.UserLoginBean;
import com.capgemini.airlinereservationsystem.dto.UserRegistrationBean;
import com.capgemini.airlinereservationsystem.exception.DatabaseConnectivityException;
import com.capgemini.airlinereservationsystem.exception.InvalidInputDetailsException;
import com.capgemini.airlinereservationsystem.exception.LoginFailedException;

public class LoginRegDaoImplementation implements LoginRegDaoInterface {

	Properties pro = null;

	public LoginRegDaoImplementation() {
		try {
			FileInputStream fis = new FileInputStream("db.properties");
			pro = new Properties();
			pro.load(fis);
			Class.forName(pro.getProperty("driver")).newInstance();
		} catch (Exception e) {
			throw new LoginFailedException();
		}
	}

	@Override
	public List<String> userlogin() {

		try (Connection con = DriverManager.getConnection(pro.getProperty("dburl"));
				PreparedStatement pstmt = con.prepareStatement(pro.getProperty("ulquery"));) {

			pstmt.setString(1, UserLoginBean.getCustomerName());

			ResultSet rs = pstmt.executeQuery();
			List<String> al = new ArrayList<String>();
			while (rs.next()) {
				al.add(rs.getString("customer_name"));
				al.add(rs.getString("password"));

			}
			return al;
		} catch (Exception e) {
			throw new LoginFailedException();
		}
	}

	@Override
	public List<String> adminlogin() {

		try (Connection con = DriverManager.getConnection(pro.getProperty("dburl"));
				PreparedStatement pstmt = con.prepareStatement(pro.getProperty("alquery"));) {

			pstmt.setString(1, AdminLoginBean.getAdminName());

			ResultSet rs = pstmt.executeQuery();
			List<String> al = new ArrayList<String>();

			while (rs.next()) {

				al.add(rs.getString("admin_name"));
				al.add(rs.getString("password"));

			}
			return al;
		} catch (Exception e) {
			throw new LoginFailedException();

		}
	}

	@Override
	public int adminRegistration() {

		try (Connection con = DriverManager.getConnection(pro.getProperty("dburl"));
				PreparedStatement pstmt = con.prepareStatement(pro.getProperty("arquery"))) {

			pstmt.setInt(1, AdminRegistrationBean.getAdminId());
			pstmt.setString(2, AdminRegistrationBean.getAdminName());

			pstmt.setString(3, AdminRegistrationBean.getPassword());

			pstmt.setString(4, AdminRegistrationBean.getEmail());
			pstmt.setLong(5, AdminRegistrationBean.getPhoneNumber());

			int res = pstmt.executeUpdate();
			return res;

		} catch (Exception e) {
			throw new InvalidInputDetailsException();

		}
	}

	@Override
	public int userRegistration() {

		try (Connection con = DriverManager.getConnection(pro.getProperty("dburl"));
				PreparedStatement pstmt = con.prepareStatement(pro.getProperty("urquery"))) {

			pstmt.setInt(1, UserRegistrationBean.getCustomerId());
			pstmt.setString(2, UserRegistrationBean.getCustomerName());
			pstmt.setString(3, UserRegistrationBean.getPassword());
			pstmt.setString(4, UserRegistrationBean.getDob());
			pstmt.setLong(5, UserRegistrationBean.getPhoneNumber());
			pstmt.setString(6, UserRegistrationBean.getEmail());
			pstmt.setString(7, UserRegistrationBean.getGovtId());
			pstmt.setString(8, UserRegistrationBean.getGender());
			pstmt.setString(9, UserRegistrationBean.getNationality());

			int res = pstmt.executeUpdate();
			return res;

		} catch (Exception e) {
			throw new InvalidInputDetailsException();
		}
	}
}
