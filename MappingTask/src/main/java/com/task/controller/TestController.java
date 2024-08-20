package com.task.controller;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.task.entity.User;

@RestController
public class TestController {

	// root url
	@GetMapping("/api")
	public String displayMsg() {
		return "Hello";
	}

	@GetMapping("/api/login/{username}")
	public String login(@PathVariable String username) {
		return "username: " + username;
	}

	@GetMapping("/api/login/{username}/{password}")
	public String loginUser(@PathVariable String username, @PathVariable String password) {
		return "username: " + username + " password: " + password;
	}

	@DeleteMapping("/api/delete/{username}")
	public String deleteUser(@PathVariable String username) {
		return username + " is deleted";
	}

	@PutMapping("/api/update")
	public User updateUser(@RequestBody User u) {
		return u;
	}

	@PostMapping("/api/add")
	public User addUser(@RequestBody User u) {
		return u;
	}

	// url with key value pair (with ?)
	// http://localhost:8091/api/user?username=mayur
	@GetMapping("/api/user")
	public String m1(@RequestParam String username) {
		return username;
	}

	// using @PathVariable and @RequestParam
	// http://localhost:8091/api/123?username=mayur
	@GetMapping("/api/{id}")
	public String m2(@PathVariable int id, @RequestParam String username) {
		return id + " " + username;
	}

	// http://localhost:8091/api/userid?id=123&username=mayur
	@GetMapping("/api/userid")
	public String m3(@RequestParam int id, @RequestParam String username) {
		return id + " " + username;
	}
}
