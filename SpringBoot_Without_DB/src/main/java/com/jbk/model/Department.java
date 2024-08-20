package com.jbk.model;

public class Department {

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName
				+ ", departmentStrength=" + departmentStrength + ", creationDate=" + creationDate + "]";
	}

	private int departmentId;
	private String departmentName;
	private String departmentStrength;
	private String creationDate;

	public Department() {
		super();
	}

	public Department(int departmentId, String departmentName, String departmentStrength, String creationDate) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.departmentStrength = departmentStrength;
		this.creationDate = creationDate;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentStrength() {
		return departmentStrength;
	}

	public void setDepartmentStrength(String departmentStrength) {
		this.departmentStrength = departmentStrength;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

}
