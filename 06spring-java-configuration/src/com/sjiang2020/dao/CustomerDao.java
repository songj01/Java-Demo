package com.sjiang2020.dao;

import java.util.List;

import com.sjiang2020.model.Customer;

public interface CustomerDao {
	
	public void addCustomer(Customer newCustomer);
	public List<Customer> findAll();
	public Customer findById(int id);

}
