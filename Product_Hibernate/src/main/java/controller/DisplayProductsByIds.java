package controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Product;

public class DisplayProductsByIds {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure().addAnnotatedClass(Product.class);
		SessionFactory sf = cfg.buildSessionFactory();

		Session sess = sf.openSession();
		
		List<Product> ls = sess.byMultipleIds(Product.class).multiLoad(2,3);
		
		for (Product product : ls) {
			System.out.println(product);
		}
	}

}
