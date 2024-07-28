package controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import entity.Player;
import hibernateconfig.HibernateConfigure;

public class DisplayAllData {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateConfigure.getSessionFactory();

		Session sesn = sessionFactory.openSession();

		Criteria criteria = sesn.createCriteria(Player.class);

		List<Player> players = criteria.list();

		for (Player player : players) {
			System.out.println(player);
		}

	}

}
