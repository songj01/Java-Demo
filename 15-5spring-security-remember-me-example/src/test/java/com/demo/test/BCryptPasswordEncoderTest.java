package com.demo.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderTest {
	

	public void testPasswordEncode() {
		String encoded=new BCryptPasswordEncoder().encode("admin@123");
		System.out.println(encoded);
	}
	
}
