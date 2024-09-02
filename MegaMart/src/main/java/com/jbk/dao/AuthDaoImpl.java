package com.jbk.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entity.User;

@Repository
public class AuthDaoImpl implements AuthDao {
	
	@Autowired
	private SessionFactory factory;
	
	@Override
	public int loginRequest(String username, String password) {
		Session session = null;
		int statusCode;
		
		try {
			session = factory.openSession();
			User user = session.get(User.class, username);
			
			if(user!=null) {
				if(username.equals(user.getUsername()) & password.equals(user.getPassword())) {
					statusCode = 1; //success
				}
				else {
					statusCode = 2; //invalid password
				}
			}
			else {
				statusCode = 3; //no user found
			}
		} catch (Exception e) {
			e.printStackTrace();
			statusCode = 4; //error
		} finally {
			session.close();
		}
		return statusCode;
	}

}
