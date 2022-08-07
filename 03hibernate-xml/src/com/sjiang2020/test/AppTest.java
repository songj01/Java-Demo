package com.sjiang2020.test;

import org.junit.jupiter.api.Test;

import com.sjiang2020.dao.UserDaoImp;

public class AppTest {
	@Test
	public void testApp() {
		
		UserDaoImp userDaoImp = new UserDaoImp();
	//	userDaoImp.createUser();
		userDaoImp.findAll();
	}

}
