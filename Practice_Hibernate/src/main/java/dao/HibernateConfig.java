package dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Employee;

//hinernate configuration
public class HibernateConfig {

	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure().addAnnotatedClass(Employee.class);
//		SessionFactory sessionFactory = configuration.buildSessionFactory();
//		return sessionFactory;
		
		return configuration.buildSessionFactory();
	}
}
