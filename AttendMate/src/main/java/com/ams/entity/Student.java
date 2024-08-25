package com.ams.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Student {
	@Id
	private long rollNumber;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String gender;
	private String dateOfBirth;
	private String address;
	private String studentId;
	private String department;
	private String className;

	
}
