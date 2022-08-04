package com.sjiang2020.test;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptPasswordEncoderTest {
	
	@Test
	public void testPasswordEncode() {
		String password = new BCryptPasswordEncoder().encode("admin@123");
		
		System.out.println(password);
	}

}
