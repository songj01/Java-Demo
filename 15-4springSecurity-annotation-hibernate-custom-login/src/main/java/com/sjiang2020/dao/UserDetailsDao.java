package com.sjiang2020.dao;

import com.sjiang2020.model.User;

public interface UserDetailsDao {
  User findUserByUsername(String username);
}
