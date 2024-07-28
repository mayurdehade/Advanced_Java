package controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Player;
import hibernateconfig.HibernateConfigure;

public class LoadPlayer {

	public static void main(String[] args) {
		SessionFactory sf = HibernateConfigure.getSessionFactory();
		Session s = sf.openSession();
		
		//load methods is similar to get but if record not found then it throws error and it faster than get
		Player p = s.load(Player.class, 2);
		
		System.out.println(p);
	}

}
