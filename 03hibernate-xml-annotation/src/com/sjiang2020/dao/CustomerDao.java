package com.sjiang2020.dao;

import java.util.List;

import com.sjiang2020.model.Customer;

public interface CustomerDao {
	
	public void createCustomer();
	
	public List<Customer> findAll();
	
	public Customer findById(int id);

}
