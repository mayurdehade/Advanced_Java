package controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import entity.Player;
import hibernateconfig.HibernateConfigure;

public class GetPerticularRecord {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateConfigure.getSessionFactory();

		Session sesn = sessionFactory.openSession();

		Criteria criteria = sesn.createCriteria(Player.class);
		
		criteria.setFirstResult(4);
		criteria.setMaxResults(4);
		
		List<Player> players = criteria.list();

		for (Player player : players) {
			System.out.println(player);
		}

	}

}
