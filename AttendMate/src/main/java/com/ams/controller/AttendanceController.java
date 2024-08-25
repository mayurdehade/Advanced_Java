package com.ams.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ams.model.AttendanceDto;
import com.ams.service.AttendanceService;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {
	
	@Autowired
	private AttendanceService service;
	
	@PostMapping("/take-attendance")
	public String takeAttendance(@RequestBody AttendanceDto attendanceDto) {
		return service.takeAttendance(attendanceDto);
	}
	
	@GetMapping("/show-attendance")
	public List<Object> showAttendance() {
		return service.showAttendance();
		
	}

}
