package com.sjiang2020.main;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sjiang2020.model.Customer;
import com.sjiang2020.service.CustomerService;

public class App {
	
	public static void main(String[] args) {

		
		try (ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml")
				
				) {
			CustomerService customerService = appContext.getBean("customerServiceImp", CustomerService.class);
			List<Customer> customerList = customerService.findAll();
			for(Customer list:customerList) {
				System.out.println(list);
			}
		} catch (BeansException e) {
			e.printStackTrace();
		}
	}

}
