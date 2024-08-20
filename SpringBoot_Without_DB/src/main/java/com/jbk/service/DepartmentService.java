package com.jbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jbk.dao.DepartmentDao;
import com.jbk.model.Department;

//Business logic use @Service annotation
//Provide metadata
//@Component
@Service
public class DepartmentService {

//	DepartmentDao dao = new DepartmentDao();
	
	//Any one type of injection can be used

	@Autowired //Field Injection
	private DepartmentDao dao;

//	@Autowired //Setter Injection 
//	public void setDao(DepartmentDao dao) {
//		this.dao = dao;
//	}
	
//	@Autowired //Constructor Injection
//	public DepartmentService(DepartmentDao dao) {
//		super();
//		this.dao = dao;
//	}

	public String addDepartment(Department department) {
		String msg = dao.addDepartment(department);
		return msg;
	}

	public List<Department> allDepartment() {
		return dao.allDepartment();
	}

	public Department getDepartmentByName(String name) {
		Department department = dao.getDepartmentByName(name);
		return department;
	}

	public String deleteDept(int id) {
		String msg = dao.deleteDept(id);
		return msg;
	}
}
