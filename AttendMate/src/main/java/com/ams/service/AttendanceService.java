package com.ams.service;

import java.util.List;

import com.ams.model.AttendanceDto;

public interface AttendanceService {
	
	public String takeAttendance(AttendanceDto attendanceDto);
	
	public List<Object> showAttendance();
}
