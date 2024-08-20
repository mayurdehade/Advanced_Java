package com.jbk.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.pojo.Product;

@RestController
public class TestController {
	
	//GetMapping annotation maps HTTPS GET requests to a specific handler method in spring controller
	//GetMapping returns the url data in variable
	//@PathVariable help to get url data
	@GetMapping("/getproduct/{pname}")
	public String getProduct(@PathVariable String pname) {
		return pname;
	}
	
	
	@DeleteMapping("/deleteproduct/{pname}")
	public String deleteProduct(@PathVariable String pname) {
		return "deleted..."+pname;
	}
	
	@PostMapping("/addproduct")
	public Product addProduct(@RequestBody Product product) {
		System.out.println(product.getId());
		System.out.println(product.getName());
		System.out.println(product.getQty());
		return product;
	}
	
	
	@PutMapping("/putproduct")
	public Product returnProduct(@RequestBody Product product) {
		System.out.println(product.getId());
		System.out.println(product.getName());
		System.out.println(product.getQty());
		return product;
	}
}
