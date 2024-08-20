package com.entity;

public class Student {
	
	private int studentId;
	private String studentName;
	
	//creating instance
	private static Student instance;
	
	//private constructor
	private Student() {
		super();
	}

	//method for creating and returning single object
	public static Student getInstance() {
		if(instance == null) {
			synchronized (Student.class) {
				if(instance == null) {
					instance = new Student();
				}
			}
		}
		return instance;
	}
	
	
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	
	

}
