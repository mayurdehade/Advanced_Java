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

import com.ams.entity.Subject;
import com.ams.service.SubjectService;

@RestController
@RequestMapping("/subject")
public class SubjectController {
	@Autowired
	private SubjectService service;
	
	@GetMapping("/get-all-subjects")
	public List<Subject> getAllSubjects() {
		List<Subject> list = service.getAllSubjects();
		return list;
	}
	
	@PostMapping("/add-subject")
	public String addSubject(@RequestBody Subject subject) {
		String msg = service.addSubject(subject);
		return msg;
	}
	
	@GetMapping("/get-subject-by-id/{id}")
	public Subject getSubjectById(@PathVariable long id) {
		Subject subject = service.getSubjectById(id);
		return subject;
	}
	
	@PutMapping("/update-subject")
	public String updateSubject(@RequestBody Subject subject) {
		String msg = service.updateSubject(subject);
		return msg;
	}
	
	@DeleteMapping("/delete-subject/{id}")
	public String deleteStudent(@PathVariable long id) {
		String msg = service.deleteSubject(id);
		return msg;
	}

}
