package com.jbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jbk.entity.User;
import com.jbk.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;

	@GetMapping("/register")
	public String registerPage() {
		return "register-user";
	}

	// register request
	@PostMapping("register-user")
	public String registerUser(@ModelAttribute User user, Model model) {
		int statusCode = service.registerRequest(user);

		if (statusCode == 1) {
			model.addAttribute("msg", "Please Login!");
			return "login";
		} else {
			model.addAttribute("msg", "Something went wrong...!");
			return "register";
		}
	}

	@GetMapping("/delete-user/{username}")
	public String deleteUser(@PathVariable String username, Model model) {
		boolean isDeleted = service.deleteUser(username);
		String rd = null;
		if(isDeleted) {
			model.addAttribute("msg", "User Deleted !");
		} else {
			model.addAttribute("msg", "Someting went wrong !");
		}
		
		return "redirect:/get-all-users";
	}

	@GetMapping("/get-user-by-username/{username}")
	public String getUserByUsername(@PathVariable String username, Model model) {
		User user = service.getUserByUsername(username);
		model.addAttribute("user", user);
		return "update-user";
	}
	
	@GetMapping("/get-all-users") 
	public String getAllUsers(Model model){
		List<User> allUsers = service.getAllUsers();
		model.addAttribute("allUsers", allUsers);
		return "home";
	}
	
	@PostMapping("/get-user-by-username/update-user")
	public String updateUser(@ModelAttribute User user, Model model) {
		System.out.println(user);
		String msg = service.updateUser(user);
		model.addAttribute("msg", msg);
		return "redirect:/get-all-users";
	}
}
