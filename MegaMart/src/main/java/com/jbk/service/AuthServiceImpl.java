package com.jbk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.AuthDao;

@Service
public class AuthServiceImpl implements AuthService {
	@Autowired
	private AuthDao dao;
	
	@Override
	public int loginRequest(String username, String password) {
		return dao.loginRequest(username, password);
	}

}
