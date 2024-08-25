package com.ams.dao;

import java.util.List;

import com.ams.entity.Subject;

public interface SubjectDao {
	
	public List<Subject> getAllSubjects();

	public String addSubject(Subject subject);

	public Subject getSubjectById(long id);

	public String updateSubject(Subject subject);

	public String deleteSubject(long id);
}
