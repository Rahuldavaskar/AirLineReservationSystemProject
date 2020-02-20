package com.capgemini.airlinereservationsystem.dao;

import java.util.List;

public interface LoginRegDaoInterface {

	public List<String> userlogin();

	public List<String> adminlogin();

	public int userRegistration();

	public int adminRegistration();
}