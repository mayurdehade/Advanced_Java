package com.ams.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ams.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private SessionFactory factory;

	//get all student 
	@Override
	public List<Student> getAll() {
		Session session = null;
		try {
			session = factory.openSession();
			Criteria criteria = session.createCriteria(Student.class);
			List<Student> list = criteria.list();
			return list;
		} catch (Exception e) {
			e.getMessage();
		} finally {
			session.close();
		}
		return null;
	}

	//add student
	@Override
	public String addStudent(Student student) {
		Session session = null;
		try {
			session = factory.openSession();
			session.save(student);
			session.beginTransaction().commit();
			return "Student Added";
		} catch (Exception e) {
			e.getMessage();
		} finally {
			session.close();
		}
		return "Student not inserted";
	}

	//get single student data
	@Override
	public Student getStudentById(long id) {
		Session session = null;
		try {
			session = factory.openSession();
			Student student = session.get(Student.class, id);
			return student;
		} catch (Exception e) {
			e.getMessage();
		} finally {
			session.close();
		}
		
		return null;
	}

	//update operation
	@Override
	public String updateStudent(Student student) {
		Session session = null;
		try {
			session = factory.openSession();
			session.update(student);
			session.beginTransaction().commit();
			return "Student data updated";
		} catch (Exception e) {
			e.getMessage();
		} finally {
			session.close();
		}
		return "Student not found";
	}

	//delete operation 
	@Override
	public String deleteStudent(long id) {
		Session session = null;
		try {
			session = factory.openSession();
			Student student = session.get(Student.class, id);
			session.delete(student);
			session.beginTransaction().commit();
			return "Student Deleted...";
		} catch (Exception e) {
			e.getMessage();
		} finally {
			session.close();
		}
		return "Student not found";
	}

	@Override
	public List<Student> getStudentsByIds(List<Long> list) {
		Session session = null;
		List<Student> students = null;
		try {
			session = factory.openSession();
			students = session.byMultipleIds(Student.class).multiLoad(list);
		} catch (Exception e) {
			e.getMessage();
		} finally {
			session.close();
		}
		return students;
	}

}
