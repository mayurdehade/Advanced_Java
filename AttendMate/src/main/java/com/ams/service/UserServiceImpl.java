package com.ams.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.dao.UserDao;
import com.ams.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao dao;

	@Override
	public User loginUser(User User) {
		return dao.loginUser(User);
	}

	@Override
	public String registerUser(User user) {
		return dao.registerUser(user);
	}

	@Override
	public User getUserByUsername(String username) {
		return dao.getUserByUsername(username);
	}

	@Override
	public List<User> getallUser() {
		return dao.getallUser();
	}

	@Override
	public String deleteUser(String username) {
		return dao.deleteUser(username);
	}

}
