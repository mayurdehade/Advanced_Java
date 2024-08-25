package com.ams.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "attendance")
public class Attendance {
	@Id
	private String id;
	private String date;
	private String time;
	private int count;

	// Mapping
	@ManyToOne
	@JoinColumn(name = "username")
	private User user;

	@ManyToOne
	@JoinColumn(name = "")
	private Subject subject;

	@ManyToMany
	@JoinTable(
			name = "student_attendance", 
			joinColumns = @JoinColumn(name = "attendanceid"), 
			inverseJoinColumns = @JoinColumn(name = "studentId"))
	private List<Student> students;

}
