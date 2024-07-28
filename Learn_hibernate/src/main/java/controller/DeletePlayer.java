package controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Player;
import hibernateconfig.HibernateConfigure;

public class DeletePlayer {

	public static void main(String[] args) {
		
		SessionFactory sess = HibernateConfigure.getSessionFactory();
		Session s = sess.openSession();
		
		Player p = s.get(Player.class, 1);
		
		s.delete(p);
		
		s.beginTransaction().commit();
		
		System.out.println("Deleted");
		
	}

}
