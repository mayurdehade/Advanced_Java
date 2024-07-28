package hibernateconfig;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Player;

public class HibernateConfigure {
	
	public static SessionFactory getSessionFactory() {
		Configuration cfg = new Configuration();
		cfg.configure().addAnnotatedClass(Player.class);
		SessionFactory sess = cfg.buildSessionFactory();
		return sess;
	}
}
