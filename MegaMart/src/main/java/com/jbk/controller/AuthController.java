package com.jbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jbk.entity.User;
import com.jbk.model.LoginRequest;
import com.jbk.service.AuthService;
import com.jbk.service.UserService;


//@Controller is used for rendering views (like HTML pages), 
//while @RestController is used for returning data in a RESTful service.
//In @Controller, you may need to explicitly annotate methods with 
//@ResponseBody if you want to return data instead of a view,
//while in @RestController, this is handled automatically.


@Controller
public class AuthController {
	
	@Autowired
	private AuthService service;
	
	@Autowired
	private UserService userService;

	
	// Handles the GET request for the login page and returns the login view.
	@GetMapping("/")
	public String loginPage() {
		return "login"; // returns the "login.jsp" page
	}
	
//	@PostMapping("login-user")
	// Maps HTTP POST requests to "/login-user" to this method.
	// This URL is typically the form's action attribute.
//	public String loginUser(@RequestParam String username, @RequestParam String password) {
//		
//		int statusCode = service.loginRequest(username, password);
//		
//		if(statusCode == 1) {
//			return "home";
//		} else if( statusCode == 2) {
//			return "register";
//		} else {
//			return "login";
//		}
//		
//	}

	// Handles the POST request for logging in a user.
	// Uses @ModelAttribute to bind form data to the LoginRequest object.
	@PostMapping("login-user")
	public String loginUser(@ModelAttribute LoginRequest loginRequest, Model model) {
		int statusCode = service.loginRequest(loginRequest.getUsername(), loginRequest.getPassword());
		
		//Model is used to give custom message

		if(statusCode == 1) {
			//get all user
			List<User> list = userService.getAllUsers();
			
			model.addAttribute("allUsers", list);
			return "home"; //success
		} else if(statusCode == 2) {
			model.addAttribute("msg", "Invalid Password!");
			return "login"; //invalid password
		} else if(statusCode == 3) {
			model.addAttribute("msg", "Invalid Username and Password!");
			return "login"; //no username and password
		}else {
			model.addAttribute("msg", "Something went wrong!");
			return "login"; //error
		}
		
	}
	
	
	
	
	
	
	
}
