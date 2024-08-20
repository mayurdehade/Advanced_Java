package com.jbk.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.jbk.model.Department;

//Dao class use @Repositoty annotation
//@Component
@Repository
public class DepartmentDao {

	List<Department> departmentList = new ArrayList<Department>();

	public String addDepartment(Department department) {
		boolean isExist = false;
		for (Department dept : departmentList) {
			if (dept.getDepartmentId() == department.getDepartmentId()
					|| dept.getDepartmentName().equals(department.getDepartmentName())) {
				isExist = true;
				return "Already exist!";
//				break;
			}
		}
//		if(isExist) {
//			return "Already exist!";
//		} else {
//			departmentList.add(department);
//		}
		departmentList.add(department);
		return "Department Added Successfully!!!";
	}

	public List<Department> allDepartment() {
		return departmentList;
	}

	public Department getDepartmentByName(String name) {
		for (Department department : departmentList) {
//			if(department.getDepartmentName().equals(name)){
//				return department;
//			}
			if (department.getDepartmentName().toLowerCase().equals(name.toLowerCase())) {
				return department;
			}
		}
		return null;
	}

	public String deleteDept(int id) {
		for (Department department : departmentList) {
			if (department.getDepartmentId() == id) {
				departmentList.remove(department);
				return "Department Deleted!!!";
			}
		}
		return "Department not found";
	}

}
