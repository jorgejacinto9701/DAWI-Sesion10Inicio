package com.cibertec.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class DecoderPassword {

	public static void main(String[] args) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		String password = "luis";
		String encodedPassword = "$2a$10$n/OaRoTws6ytOgVrIA1lLO.YINecSDWpDfrAqeJYqC5G7rVfHCeuu";
		
		boolean isPasswordMatch = passwordEncoder.matches(password, encodedPassword);
		System.out.println("Password : " + password + "   isPasswordMatch    : " + isPasswordMatch);
		
	}
}
