package com.capgemini.airlinereservationsystem.validation;

import java.util.Scanner;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordValidator {

	public static boolean passwordValidator(String password) {
		return BCrypt.checkpw(password, PasswordEncoder.passwordEncoder(password));
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the password");
		String password = scan.nextLine();
		System.out.println(passwordValidator(password));
	}
}
