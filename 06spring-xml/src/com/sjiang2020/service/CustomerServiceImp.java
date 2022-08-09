package com.sjiang2020.service;

import java.util.List;

import com.sjiang2020.dao.CustomerDaoImp;
import com.sjiang2020.model.Customer;

public class CustomerServiceImp implements CustomerService {
	
	CustomerDaoImp customerDaoImp;
	
	
	
	public void setCustomerDaoImp(CustomerDaoImp customerDaoImp) {
		this.customerDaoImp = customerDaoImp;
	}

	public CustomerServiceImp() {

	}

	@Override
	public void addCustomer(Customer newCustomer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Customer> findAll() {
	
		return customerDaoImp.findAll();
	}

	@Override
	public Customer findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
