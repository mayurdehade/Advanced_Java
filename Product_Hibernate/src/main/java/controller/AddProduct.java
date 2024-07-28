package controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Product;

public class AddProduct {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure().addAnnotatedClass(Product.class);
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session sess = sf.openSession();
		
		Product p = new Product(1, "Laptop", 20000f);
		
		sess.save(p);
		sess.beginTransaction().commit();
	}

}
