package com.example.demo;

import lombok.Data;

@Data
//@noargsConstructor
public class LoginRequest {
	String username;
	String password;
	
	
	/*
	 * public String getUsername() { return username; }
	 * 
	 * 
	 * 
	 * 
	 * public String getPassword() { return password; }
	 * 
	 * public String toString() { return "LoginRequest [username=" + username +
	 * ", password=" + password + "]"; }
	 * 
	 */
}
