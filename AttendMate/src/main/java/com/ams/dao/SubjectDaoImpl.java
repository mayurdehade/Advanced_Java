package com.ams.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ams.entity.Subject;

@Repository
public class SubjectDaoImpl implements SubjectDao {

	@Autowired
	private SessionFactory factory;

	@Override
	public List<Subject> getAllSubjects() {
		Session session = null;
		try {
			session = factory.openSession();
			Criteria criteria = session.createCriteria(Subject.class);
			List<Subject> list = criteria.list();
			return list;
		} catch (Exception e) {
			e.getMessage();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public String addSubject(Subject subject) {
		Session session = null;
		try {
			session = factory.openSession();
			session.save(subject);
			session.beginTransaction().commit();
			return "Subject added successfully...";
		} catch (Exception e) {
			e.getMessage();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Subject getSubjectById(long id) {
		Session session = null;
		try {
			session = factory.openSession();
			Subject subject = session.get(Subject.class, id);
			return subject;
		} catch (Exception e) {
			e.getMessage();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public String updateSubject(Subject subject) {
		Session session = null;
		try {
			session = factory.openSession();
			session.update(subject);
			session.beginTransaction().commit();
			return "Subject updated...";
		} catch (Exception e) {
			e.getMessage();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public String deleteSubject(long id) {
		Session session = null;
		try {
			session = factory.openSession();
			Subject subject = session.get(Subject.class, id);
			session.delete(subject);
			session.beginTransaction().commit();
			return "Subject deleted...";
		} catch (Exception e) {
			e.getMessage();
		} finally {
			session.close();
		}
		return null;
	}

}
