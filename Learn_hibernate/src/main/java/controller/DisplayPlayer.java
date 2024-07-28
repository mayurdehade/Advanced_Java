package controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Player;

public class DisplayPlayer {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure().addAnnotatedClass(Player.class);
		SessionFactory sess = cfg.buildSessionFactory();
		Session s = sess.openSession();

		Player p = s.get(Player.class, 2);
		
		System.out.println(p);
	}

}
