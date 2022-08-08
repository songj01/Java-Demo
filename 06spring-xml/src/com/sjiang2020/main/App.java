package com.sjiang2020.main;

import java.util.List;

import com.sjiang2020.model.Customer;
import com.sjiang2020.service.CustomerService;
import com.sjiang2020.service.CustomerServiceImp;

public class App {
	
	public static void main(String[] args) {

		CustomerService customerService = new CustomerServiceImp();
		
		List<Customer> customerList = customerService.findAll();
		for(Customer list:customerList) {
			System.out.println(list);
		}
	}

}
