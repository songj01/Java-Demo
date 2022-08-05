package com.sjiang2020.test;

import org.junit.jupiter.api.Test;

import com.sjiang2020.dao.CustomerDaoImp;

public class AppTest {

	@Test
	public void test() {
		CustomerDaoImp customerDaoImp = new CustomerDaoImp();
		customerDaoImp.createCustomer();
		
	}
	
	
}
