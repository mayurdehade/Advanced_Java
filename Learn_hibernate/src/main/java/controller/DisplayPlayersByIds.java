package controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Player;
import hibernateconfig.HibernateConfigure;

public class DisplayPlayersByIds {

	public static void main(String[] args) {
		SessionFactory sf = HibernateConfigure.getSessionFactory();
		Session sess = sf.openSession();

		List<Player> players = sess.byMultipleIds(Player.class).multiLoad(1, 2);

		for (Player player : players) {
			System.out.println(player);
		}
		
		
	}

}
