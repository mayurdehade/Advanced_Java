package com.jbk.dao;

import java.util.List;

import com.jbk.entity.User;

public interface UserDao {
	public int registerRequest(User user);
	
	public List<User> getAllUsers();
	
	public boolean deleteUser(String username);
	
	public String updateUser(User user);
	
	public User getUserByUsername(String username);
}
