package com.jbk.dao;

import java.util.List;

import com.jbk.entity.Product;
import com.jbk.entity.User;

public interface ProductDao {
	public String addProduct(Product product);

	public List<Product> allProducts();

	public String deleteProduct(String pid);

	public Product getProductById(String pid);
	
	public String updateProduct(Product product);
}
