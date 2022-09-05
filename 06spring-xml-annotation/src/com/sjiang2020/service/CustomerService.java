package com.sjiang2020.service;

import java.util.List;

import com.sjiang2020.model.Customer;

public interface CustomerService {
	
	public void addCustomer(Customer newCustomer);
	public List<Customer> findAll();
	public Customer findById(int id);

}
