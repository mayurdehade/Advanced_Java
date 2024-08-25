package com.ams.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ams.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory factory;

	@Override
	public User loginUser(User user) {

		Session session = null;

		try {
			session = factory.openSession();
			User user2 = session.get(User.class, user.getUsername());
			if (user.getUsername().equals(user2.getUsername()) && user.getPassword().equals(user2.getPassword())) {
				return user2;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public String registerUser(User user) {
		Session session = null;
		try {
			session = factory.openSession();
			session.save(user);
			session.beginTransaction().commit();
			return "User added...";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public User getUserByUsername(String username) {
		Session session = null;
		try {
			session = factory.openSession();
			User user = session.get(User.class, username);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<User> getallUser() {
		Session session = null;
		try {
			session = factory.openSession();
			Criteria criteria = session.createCriteria(User.class);
			List<User> list = criteria.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public String deleteUser(String username) {
		Session session = null;
		try {
			session = factory.openSession();
			User user = session.get(User.class, username);
			session.delete(user);
			session.beginTransaction().commit();
			return "User deleted...";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
