package com.tka.onetoone;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfigure {
	
	public static SessionFactory getSessionFactory() {
		Configuration cfg = new Configuration();
		cfg.configure().addAnnotatedClass(Player.class).addAnnotatedClass(Address.class);
		SessionFactory sess = cfg.buildSessionFactory();
		return sess;
	}
}
