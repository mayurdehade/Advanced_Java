package com.ams.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.dao.StudentDao;
import com.ams.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao dao;

	@Override
	public List<Student> getAll() {
		List<Student> list = dao.getAll();
		return list;
	}

	@Override
	public String addStudent(Student student) {
		String msg = dao.addStudent(student);
		return msg;
	}

	@Override
	public Student getStudentById(long id) {
		Student student = dao.getStudentById(id);
		return student;
	}

	@Override
	public String updateStudent(Student student) {
		String msg = dao.updateStudent(student);
		return msg;
	}

	@Override
	public String deleteStudent(long id) {
		String msg = dao.deleteStudent(id);
		return msg;
	}

	@Override
	public List<Student> getStudentsByIds(List<Long> list) {
		return dao.getStudentsByIds(list);
	}

}
