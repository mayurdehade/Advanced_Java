package controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Product;

public class DeleteProduct {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure().addAnnotatedClass(Product.class);
		SessionFactory sf = cfg.buildSessionFactory();

		Session sess = sf.openSession();
		
		Product p = sess.get(Product.class, 1);
		
		sess.delete(p);
		
		sess.beginTransaction().commit();
	}

}
