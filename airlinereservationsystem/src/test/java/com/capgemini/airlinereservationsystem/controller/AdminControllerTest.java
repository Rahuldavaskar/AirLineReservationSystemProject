package com.capgemini.airlinereservationsystem.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AdminControllerTest {

	AdminController c1 = new AdminController();
	@DisplayName("Admin Controller Test Case")
	@Test
	void test() {
		c1.cancelFlight();
	}
	
	@Test
	void test1() {
		c1.checkFlight();
	}
    
	@Test
	void test2() {
		c1.checkPrice();
	}
	
	@Test
	void test3() {
		c1.checkTicket();
	}
	
	@Test
	void test4() {
		c1.deleteTicket();
	}
	
	@Test
	void test5() {
		c1.flightInfo();
	}




	
}
