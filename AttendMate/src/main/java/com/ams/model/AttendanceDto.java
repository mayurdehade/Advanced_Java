package com.ams.model;

import java.util.List;

import lombok.Data;

@Data
public class AttendanceDto {
	
	private String username;
	private String date;
	private String time;
	private List<Long> studentId;
	//subject id
	private long id;
	

}
