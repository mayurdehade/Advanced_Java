package com.jbk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//create rest controller 
@RestController
public class TestController {
	//GetMapping annotation connect with spring boot application
	@GetMapping("/")
	public String getMessage() {
		return "Hello World!";
	}
	
	@GetMapping("/hello")
	public String getHello() {
		return "Hello Spring";
	}
	
	@GetMapping("/wlc")
	public String getWelcome() {
		return "Welcome...";
	}
}
