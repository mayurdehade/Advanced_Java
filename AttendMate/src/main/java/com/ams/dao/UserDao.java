package com.ams.dao;

import java.util.List;

import com.ams.entity.User;

public interface UserDao {
	public User loginUser(User User);

	public String registerUser(User user);

	public User getUserByUsername(String username);

	public List<User> getallUser();

	public String deleteUser(String username);
}
