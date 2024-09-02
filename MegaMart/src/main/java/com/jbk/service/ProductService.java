package com.jbk.service;

import java.util.List;

import com.jbk.entity.Product;

public interface ProductService {
	public String addProduct(Product product);
	
	public List<Product> allProducts();
	
	public String deleteProduct(String pid);
	
	public Product getProductById(String pid);
	
	public String updateProduct(Product product);
}
