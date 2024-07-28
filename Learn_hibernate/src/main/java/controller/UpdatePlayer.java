package controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Player;
import hibernateconfig.HibernateConfigure;

public class UpdatePlayer {

	public static void main(String[] args) {
		SessionFactory sess = HibernateConfigure.getSessionFactory();
		Session s = sess.openSession();
		
		Player p = new Player(1, "Virat Kohli", 17, 20000);
		s.update(p);
		
		s.beginTransaction().commit();
		System.out.println("Transaction Completed");
	}

}
