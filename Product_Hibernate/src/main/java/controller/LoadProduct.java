package controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Product;

public class LoadProduct {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure().addAnnotatedClass(Product.class);
		SessionFactory sf = cfg.buildSessionFactory();

		Session sess = sf.openSession();

		Product p = sess.load(Product.class, 2);

		System.out.println(p);
	}

}
