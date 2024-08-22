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
	// Handles GET requests to retrieve a product by name from the URL path
	@GetMapping("/getproduct/{pname}")
	public String getProduct(@PathVariable String pname) {
		return pname;
	}
	
	// Handles DELETE requests to delete a product by name from the URL path
	@DeleteMapping("/deleteproduct/{pname}")
	public String deleteProduct(@PathVariable String pname) {
		return "deleted..."+pname;
	}
	
	// Handles POST requests to add a new product, with product details in the request body
	@PostMapping("/addproduct")
	public Product addProduct(@RequestBody Product product) {
		System.out.println(product.getId());
		System.out.println(product.getName());
		System.out.println(product.getQty());
		return product;
	}
	
	// Handles PUT requests to update an existing product, with updated details in the request body
	@PutMapping("/putproduct")
	public Product returnProduct(@RequestBody Product product) {
		System.out.println(product.getId());
		System.out.println(product.getName());
		System.out.println(product.getQty());
		return product;
	}
}
