package controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Player;
import hibernateconfig.HibernateConfigure;

public class AddPlayer {

	public static void main(String[] args) {

//		// create object of player with some values
		Player player = new Player(1, "Virat Kohli", 18, 75);
//
//		Configuration cfg = new Configuration();
//
//		//read cfg file
//		cfg.configure().addAnnotatedClass(Player.class);
//
//		SessionFactory sf = cfg.buildSessionFactory();
//		
//		//create new session
//		Session session = sf.openSession();
		
		SessionFactory sess = HibernateConfigure.getSessionFactory();
		Session session = sess.openSession();

		session.save(player);
		//update in database
		session.beginTransaction().commit();

		System.out.println("done");
		
		
		
		

	}

}
