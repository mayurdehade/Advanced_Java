package com.ams.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ams.entity.User;
import com.ams.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService service;
	
	@PostMapping("/login-user")
	public User loginUser(@RequestBody User user) {
		return service.loginUser(user);
	}
	
	@PostMapping("/register-user")
	public String registerUser(@RequestBody User user) {
		return service.registerUser(user);
	}
	
	@GetMapping("/get-user-by-username/{username}")
	public User getUserByUsername(@PathVariable String username) {
		return service.getUserByUsername(username);
	}
	
	@GetMapping("/get-all-user")
	public List<User> getAllUser() {
		return service.getallUser();
	}
	
	@DeleteMapping("/delete-user/{username}")
	public String deleteUser(@PathVariable String username) {
		return service.deleteUser(username);
	}
}
