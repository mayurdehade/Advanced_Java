package controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Product;

public class DisplayProduct {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure().addAnnotatedClass(Product.class);
		SessionFactory sf = cfg.buildSessionFactory();

		Session sess = sf.openSession();
		
		Product p = sess.get(Product.class, 1);
		
		System.out.println(p);
	}

}
