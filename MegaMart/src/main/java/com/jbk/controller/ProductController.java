package com.jbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jbk.entity.Product;
import com.jbk.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("/new-product")
	public String newProduct() {
		return "add-product";
	}
	
	@PostMapping("/add-product")
	public String addProduct(@ModelAttribute Product product, Model model) {
		String msg = service.addProduct(product);
		model.addAttribute("msg", msg);
		return "redirect:/get-all-products";
	}
	
	@GetMapping("/get-all-products")
	public String allProducts(Model model){
		List<Product> allProducts = service.allProducts();
		model.addAttribute("allProducts",allProducts);
		return "all-products";
	}

	@GetMapping("/delete-product/{pid}")
	public String deleteProduct(@PathVariable String pid, Model model) {
		String msg = service.deleteProduct(pid);	
		model.addAttribute("msg", msg);
		return "redirect:/get-all-products";
	}
	
	@GetMapping("/get-product-by-id/{pid}")
	public String getProductById(@PathVariable String pid, Model model) {
		Product product = service.getProductById(pid);
		model.addAttribute("product", product);
		return "update-product";
	}
	
	@PostMapping("/get-product-by-id/update-product")
	public String updateProduct(@ModelAttribute Product product, Model model) {
		String msg = service.updateProduct(product);
		model.addAttribute("msg", msg);
		return "redirect:/get-all-products";
	}

}
