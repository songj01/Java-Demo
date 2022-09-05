package com.sjiang2020.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sjiang2020.model.Customer;


@Repository("customerDaoImp")
public class CustomerDaoImp implements CustomerDao{
	
	List<Customer> list = null;
	
	public CustomerDaoImp() {
		list = new ArrayList<>();
		Customer customer1 = new Customer(1, "Jimmy", "John", "7754098342","jimmy@gooel.com");
		Customer customer2 = new Customer(2, "Tom", "Hanks", "7855262365","tom@gooel.com");
		
		list.add(customer1);
		list.add(customer2);
		
	}

	@Override
	public void addCustomer(Customer newCustomer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Customer findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
