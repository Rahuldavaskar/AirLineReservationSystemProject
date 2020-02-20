package com.capgemini.airlinereservationsystem.factory;

import com.capgemini.airlinereservationsystem.dao.AdminDaoInterface;
import com.capgemini.airlinereservationsystem.dao.CustomerDaoInterface;
import com.capgemini.airlinereservationsystem.dao.impl.AdminDaoImplementation;
import com.capgemini.airlinereservationsystem.dao.impl.CustomerDaoImplementation;
import com.capgemini.airlinereservationsystem.service.AdminServiceInterface;
import com.capgemini.airlinereservationsystem.service.CustomerServiceInterface;
import com.capgemini.airlinereservationsystem.service.impl.AdminServiceImplementation;
import com.capgemini.airlinereservationsystem.service.impl.CustomerServiceImplementation;

public class Factory {

	public static AdminDaoInterface adminFactory() {
		AdminDaoInterface admin = new AdminDaoImplementation();
		return admin;
	}
	
	public static AdminServiceInterface adminService() {
		AdminServiceInterface service = new AdminServiceImplementation();
		return service;
	}
	
	public static CustomerDaoInterface customerFactory() {
		CustomerDaoInterface customer = new CustomerDaoImplementation();
		return customer;
	}
	
	public static CustomerServiceInterface customerService() {
		CustomerServiceInterface service = new CustomerServiceImplementation();
		return service;
	}
}