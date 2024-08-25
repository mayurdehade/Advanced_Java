package com.ams.service;

import java.util.List;

import com.ams.entity.Subject;

public interface SubjectService {

	public List<Subject> getAllSubjects();
	
	public String addSubject(Subject subject);
	
	public Subject getSubjectById(long id);
	
	public String updateSubject(Subject subject);
	
	public String deleteSubject(long id);
}
