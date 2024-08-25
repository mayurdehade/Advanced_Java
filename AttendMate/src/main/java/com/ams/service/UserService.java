package com.ams.service;

import java.util.List;

import com.ams.entity.User;

public interface UserService {

	public User loginUser(User User);
	
	public String registerUser(User user);
	
	public User getUserByUsername(String username);
	
	public List<User> getallUser();
	
	public String deleteUser(String username);
}
