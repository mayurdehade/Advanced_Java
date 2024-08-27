package com.ams.aop;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component  // Marks this class as a Spring component, allowing it to be detected and managed by Spring's container.
@Aspect     // Indicates that this class is an Aspect, containing advice that can be applied to different points in the application.
public class MyAdvice {

    // Logger to log the execution details, typically used for debugging and auditing.
    static Logger logger = LoggerFactory.getLogger(MyAdvice.class);
    
    @Pointcut("execution (* com.ams.controller.*.*(..))")
    // Defines a pointcut that matches the execution of any method in the classes within the com.ams.controller package.
    public void p1() {
        // This method is a dummy method and is only used to name the pointcut. No code is executed here.
    }
    
    @Before("p1()")
    // Advice that runs before any method matched by the pointcut "p1()" (before method execution).
    public void startTime() {
        // Captures the current timestamp and logs it as the start time of the method execution.
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date());
        logger.info("Execution Started at " + time);
    }
    
    @AfterReturning("p1()")
    // Advice that runs after the successful execution of any method matched by the pointcut "p1()".
    public void endTime() {
        // Captures the current timestamp and logs it as the end time of the method execution.
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date());
        logger.info("Execution Ended at " + time);
    }
    
}
