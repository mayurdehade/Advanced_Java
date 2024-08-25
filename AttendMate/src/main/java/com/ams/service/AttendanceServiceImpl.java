package com.ams.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.dao.AttendanceDao;
import com.ams.entity.Attendance;
import com.ams.model.AttendanceDto;

@Service
public class AttendanceServiceImpl implements AttendanceService {
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AttendanceDao dao;
	
	@Override
	public String takeAttendance(AttendanceDto attendanceDto) {
		//Generate id 
		String date = new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date());
		
		Attendance attendance = new Attendance();
		attendance.setId(date);
		attendance.setDate(attendanceDto.getDate());
		attendance.setTime(attendanceDto.getTime());
		attendance.setCount(attendanceDto.getStudentId().size());
		
		attendance.setStudents(studentService.getStudentsByIds(attendanceDto.getStudentId()));
		attendance.setSubject(subjectService.getSubjectById(attendanceDto.getId()));
		attendance.setUser(userService.getUserByUsername(attendanceDto.getUsername()));
		
		return dao.takeAttendance(attendance);
	}

	@Override
	public List<Object> showAttendance() {
		return null;
	}

}
