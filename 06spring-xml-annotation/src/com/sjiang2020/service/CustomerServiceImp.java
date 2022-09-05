package com.sjiang2020.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjiang2020.dao.CustomerDao;
import com.sjiang2020.dao.CustomerDaoImp;
import com.sjiang2020.model.Customer;


@Service("customerServiceImp")
public class CustomerServiceImp implements CustomerService {
	
	
	@Autowired
	CustomerDaoImp customerDaoImp;
	
	
	
	public void setCustomerDaoImp(CustomerDao customerDaoImp) {
		this.customerDaoImp = (CustomerDaoImp) customerDaoImp;
	}

	public CustomerServiceImp() {

	}
	
	

	public CustomerServiceImp(CustomerDaoImp customerDaoImp) {
		this.customerDaoImp = customerDaoImp;
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
