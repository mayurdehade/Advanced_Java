package com.ams.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.dao.SubjectDao;
import com.ams.entity.Subject;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectDao dao;
	
	@Override
	public List<Subject> getAllSubjects() {
		List<Subject> list = dao.getAllSubjects();
		return list;
	}

	@Override
	public String addSubject(Subject subject) {
		String msg = dao.addSubject(subject);
		return msg;
	}

	@Override
	public Subject getSubjectById(long id) {
		Subject subject = dao.getSubjectById(id);
		return subject;
	}

	@Override
	public String updateSubject(Subject subject) {
		String msg = dao.updateSubject(subject);
		return msg;
	}

	@Override
	public String deleteSubject(long id) {
		String msg = dao.deleteSubject(id);
		return msg;
	}
}
