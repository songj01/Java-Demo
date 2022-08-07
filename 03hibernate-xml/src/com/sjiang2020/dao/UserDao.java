package com.sjiang2020.dao;

import java.util.List;

import com.sjiang2020.model.User;

public interface UserDao {
	
	public void createUser();
	public List<User> findAll();
    public User findById(int id);
}
