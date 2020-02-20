package com.capgemini.airlinereservationsystem.validation;

import java.util.Scanner;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncoder {

	public static String passwordEncoder(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the password");
		String password = scan.nextLine();
		System.out.println(passwordEncoder(password));
	}
}
