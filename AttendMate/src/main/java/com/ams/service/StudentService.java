package com.ams.service;

import java.util.List;

import com.ams.entity.Student;

public interface StudentService {
	
	public List<Student> getAll();
	
	public String addStudent(Student student);
	
	public Student getStudentById(long id);
	
	public String updateStudent(Student student);
	
	public String deleteStudent(long id);
	
	public List<Student> getStudentsByIds(List<Long> list);
	
}
