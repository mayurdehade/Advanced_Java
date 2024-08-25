package com.ams.dao;

import java.util.List;

import com.ams.entity.Attendance;

public interface AttendanceDao {
	
	public String takeAttendance(Attendance attendance);
	
	public List<Attendance> showAttendance();
}
