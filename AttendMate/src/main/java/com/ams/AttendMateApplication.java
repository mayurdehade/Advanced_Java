package com.ams;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AttendMateApplication {
	
	//logger instance
	static Logger logger = LoggerFactory.getLogger(AttendMateApplication.class);
	

	public static void main(String[] args) {
		SpringApplication.run(AttendMateApplication.class, args);
		
		//this is used to write custom message in log file
		logger.info("Application started...");
		System.out.println("Application started...");
	}

}
