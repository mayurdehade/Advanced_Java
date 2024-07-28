package controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

import entity.Player;
import hibernateconfig.HibernateConfigure;

public class DisplayAllDataOrderByName {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateConfigure.getSessionFactory();

		Session sesn = sessionFactory.openSession();

		Criteria criteria = sesn.createCriteria(Player.class);
		
		//give variable name not column name
		criteria.addOrder(Order.desc("runs"));
		List<Player> players = criteria.list();

		for (Player player : players) {
			System.out.println(player);
		}

	}

}
