package com.jbk.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.ProductDao;
import com.jbk.entity.Product;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao dao;
	
	@Override
	public String addProduct(Product product) {
		String date = new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date());
		System.out.println(date);
		product.setProductId(date);
		return dao.addProduct(product);
	}

	@Override
	public List<Product> allProducts() {
		return dao.allProducts();
	}

	@Override
	public String deleteProduct(String pid) {
		return dao.deleteProduct(pid);
	}

	@Override
	public Product getProductById(String pid) {
		return dao.getProductById(pid);
	}

	@Override
	public String updateProduct(Product product) {
		return dao.updateProduct(product);
	}

}
