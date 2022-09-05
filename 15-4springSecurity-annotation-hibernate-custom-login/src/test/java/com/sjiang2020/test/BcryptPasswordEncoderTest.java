package com.sjiang2020.test;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptPasswordEncoderTest {
	
	public void testPasswordEncode() {
		String password = new BCryptPasswordEncoder().encode("admin@123");
		
		System.out.println(password);
	}

}
