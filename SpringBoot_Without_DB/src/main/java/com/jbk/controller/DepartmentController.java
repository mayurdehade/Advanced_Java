package com.jbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.model.Department;
import com.jbk.service.DepartmentService;

@RestController
public class DepartmentController {

	// Here we manually created object to access methods of DepartmentService class
	// methods
//	DepartmentService service = new DepartmentService();

	// Using @Autowire annotation to automatically creating of object using IOC
	// these object is null without @Autowire caused exception null object
	// use @Component annotation to class
	@Autowired
	private DepartmentService service;
	

	@PostMapping("/add-department")
	public String addDepartment(@RequestBody Department department) {
		String msg = service.addDepartment(department);
		return msg;
	}

	@GetMapping("/all-department")
	public List<Department> allDepartment() {
		return service.allDepartment();
	}

	@GetMapping("/get-dept-by-name")
	public Object getDepartmentByName(@RequestParam String name) {
		Department department = service.getDepartmentByName(name);
		if (department != null) {
			return department;
		} else {
			return "Department Not Exists!!!";
		}
	}

	@DeleteMapping("/delete-dept/{id}")
	public Object deleteDept(@PathVariable int id) {
		String msg = service.deleteDept(id);

		return allDepartment();

	}
}
