package com.ams.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ams.entity.Student;
import com.ams.service.StudentService;

@RestController
@RequestMapping("/student") // all mapping start with localhost:8080/student/
public class StudentController {

	// this is interface because we get methods from Interface (abstraction)
	@Autowired
	private StudentService service;

	@GetMapping("/get-all-students")
	public List<Student> getAll() {
		List<Student> list = service.getAll();
		return list;

	}

	@PostMapping("/add-student")
	public String addStudent(@RequestBody Student student) {
		String msg = service.addStudent(student);
		return msg;

	}

	@GetMapping("/get-student-by-id/{id}")
	public Student getStudentById(@PathVariable long id) {
		Student student = service.getStudentById(id);
		return student;
	}

	@PutMapping("/update-student")
	public String updateStudent(@RequestBody Student student) {
		String msg = service.updateStudent(student);
		return msg;
	}

	@DeleteMapping("/delete-student/{id}")
	public String deleteStudent(@PathVariable long id) {
		String msg = service.deleteStudent(id);
		return msg;
	}
}
