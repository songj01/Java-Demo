package com.sjiang2020.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.sjiang2020.dao.CustomerDao;
import com.sjiang2020.dao.CustomerDaoImp;
import com.sjiang2020.service.CustomerService;
import com.sjiang2020.service.CustomerServiceImp;

@Configuration
@ComponentScan({"com.sjiang2020"})
@PropertySource("application.properties")
public class AppConfig {
	
//	
//	@Bean("customerServiceImp")
//	public CustomerService getCustomerService() {
//		
//		CustomerServiceImp service = new CustomerServiceImp();
//		service.setCustomerDaoImp(getCustomerDao());
//		
//		return service;
//	}
//	
	
	
//	@Bean("customerDaoImp")
//	public CustomerDao getCustomerDao() {
//		return new CustomerDaoImp();
//	}
//	
	
	

}
