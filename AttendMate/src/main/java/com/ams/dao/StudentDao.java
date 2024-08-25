package com.ams.dao;

import java.util.List;

import com.ams.entity.Student;

public interface StudentDao {
	
	public List<Student> getAll();

	public String addStudent(Student student);

	public Student getStudentById(long id);

	public String updateStudent(Student student);

	public String deleteStudent(long id);
	
	public List<Student> getStudentsByIds(List<Long> list);
	
}
