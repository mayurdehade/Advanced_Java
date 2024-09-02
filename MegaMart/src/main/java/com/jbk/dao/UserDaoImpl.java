package com.jbk.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entity.User;
@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory factory;
	
	@Override
	public int registerRequest(User user) {
		Session session = null;
		int statusCode;
		try {
			session = factory.openSession();
			session.save(user);
			session.beginTransaction().commit();
			statusCode = 1;
		} catch (Exception e) {
			e.printStackTrace();
			statusCode = 2;
		} finally {
			session.close();
		}
		
		return statusCode;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> allUsers = null;
		try(Session session = factory.openSession()) {
			Criteria criteria = session.createCriteria(User.class);
			allUsers = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allUsers;
	}

	@Override
	public boolean deleteUser(String username) {
		boolean status = false;
		try(Session session = factory.openSession()) {
			User user = session.get(User.class, username);
			session.delete(user);
			session.beginTransaction().commit();
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String updateUser(User user) {
		String msg;
		try(Session session = factory.openSession()) {
			session.update(user);
			session.beginTransaction().commit();
			msg = "User updated";
		} catch (Exception e) {
			e.printStackTrace();
			msg = "Something went wrong!";
		}
		return msg;
	}

	@Override
	public User getUserByUsername(String username) {
		User user = null;
		
		try(Session session = factory.openSession()) {
			user = session.get(User.class, username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}

	
}
