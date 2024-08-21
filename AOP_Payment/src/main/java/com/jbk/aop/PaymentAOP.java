//Implementing AOP (Aspect Oriented Programming)
/*
 * Aspect-Oriented Programming (AOP) allows you to add common features like logging or security across your app without changing the main code. It separates these features into "aspects," making your code cleaner and easier to manage.
 * 
 * Key concept of AOP:
 * 1. Advice
 * 2. PointCut
 * 
 * Types of Advice: 
 * @Before advice runs before the matched method executes.
 * @After advice runs after the matched method completes, regardless of outcome.
 * @AfterReturning advice runs after the method successfully returns a result.
 * @AfterThrowing advice runs if the method throws an exception.
 */
package com.jbk.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect annotation indicates that this is an aspect
@Aspect
@Component // Register this class as a Spring bean
public class PaymentAOP {

	// Define a pointcut expression that matches the doPayment method in
	// PaymentService
	@Pointcut("execution(* com.jbk.service.PaymentService.doPayment(..)) && args(frmAcc, toAcc, amount)")
	public void pointCut(String frmAcc, String toAcc, double amount) {
		// This method is empty because it's just used to name the pointcut
	}

	// @Before advice that runs before the matched method (doPayment)
	@Before("pointCut(frmAcc, toAcc, amount)")
	public void beforePayment(String frmAcc, String toAcc, double amount) {
		System.out.println("Transaction begins...");
		System.out.println("From Account: " + frmAcc + ", To Account: " + toAcc + ", Amount: " + amount);
	}

	// @After advice that runs after the matched method (regardless of its outcome)
	@After("pointCut(frmAcc, toAcc, amount)")
	public void afterPayment(String frmAcc, String toAcc, double amount) {
		System.out.println("Transaction completed (After advice)...");
	}

	// @AfterReturning advice that runs after the matched method if it returns
	// successfully
	@AfterReturning(pointcut = "pointCut(frmAcc, toAcc, amount)", returning = "result")
	public void afterReturningPayment(String frmAcc, String toAcc, double amount, String result) {
		System.out.println("Transaction successful: " + result);
	}

	// @AfterThrowing advice that runs if the matched method throws an exception
	@AfterThrowing(pointcut = "pointCut(frmAcc, toAcc, amount)", throwing = "ex")
	public void afterThrowingPayment(String frmAcc, String toAcc, double amount, Exception ex) {
		System.out.println("Transaction failed: " + ex.getMessage());
	}
}
