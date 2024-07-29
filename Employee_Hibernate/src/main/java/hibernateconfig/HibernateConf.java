package hibernateconfig;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Address;
import entity.Employee;

public class HibernateConf {

	public static SessionFactory getSessionFactory() {
		Configuration cfg = new Configuration();
		cfg.configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Address.class);
		return cfg.buildSessionFactory();
	}
}
