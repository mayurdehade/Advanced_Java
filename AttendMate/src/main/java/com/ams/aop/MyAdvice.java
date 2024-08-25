package com.ams.aop;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {

	static Logger logger = LoggerFactory.getLogger(MyAdvice.class);
	
	@Pointcut("execution (* com.ams.controller.*.*(..))")
	public void p1() {
		//This method is a dummy method for just define pointcut
	}
	
	@Before("p1()")
	public void startTime() {
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date());
		logger.info("Execution Started at "+time);
	}
	
	@AfterReturning("p1()") //on successful execution of method
	public void endTime() {
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date());
		logger.info("Execution Ended at "+time);
		
	}
	
}
