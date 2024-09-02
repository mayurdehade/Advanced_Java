package com.jbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.UserDao;
import com.jbk.entity.User;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;
	
	@Override
	public int registerRequest(User user) {
		return dao.registerRequest(user);
	}

	@Override
	public List<User> getAllUsers() {
		return dao.getAllUsers();
	}

	@Override
	public boolean deleteUser(String username) {
		return dao.deleteUser(username);
	}

	@Override
	public String updateUser(User user) {
		return dao.updateUser(user);
	}

	@Override
	public User getUserByUsername(String username) {
		return dao.getUserByUsername(username);
	}

}
