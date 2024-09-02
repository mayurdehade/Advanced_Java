package com.jbk.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entity.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	private SessionFactory factory;

	@Override
	public String addProduct(Product product) {
		String msg;
		try(Session session = factory.openSession()) {
			session.save(product);
			session.beginTransaction().commit();
			msg = "Product Added!";
		} catch (Exception e) {
			e.printStackTrace();
			msg = "Someting went wrong!";
		}
		return msg;
	}

	@Override
	public List<Product> allProducts() {
		List<Product> allProducts = null;
		try(Session session = factory.openSession()) {
			Criteria criteria = session.createCriteria(Product.class);
			allProducts = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allProducts;
	}

	@Override
	public String deleteProduct(String pid) {
		String msg;
		try(Session session = factory.openSession()) {
			Product product = session.get(Product.class, pid);
			session.delete(product);
			session.beginTransaction().commit();
			msg = "Product Deleted";
		} catch (Exception e) {
			e.printStackTrace();
			msg = "Someting went wrong";
		}
		return msg;
	}

	@Override
	public Product getProductById(String pid) {
		Product product = null;
		try(Session session = factory.openSession()) {
			product = session.get(Product.class, pid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public String updateProduct(Product product) {
		String msg;
		try(Session session = factory.openSession()) {
			session.update(product);
			session.beginTransaction().commit();
			msg = "Product Updated";
		} catch (Exception e) {
			e.printStackTrace();
			msg = "Something went wrong";
		}
		return msg;
	}

}
