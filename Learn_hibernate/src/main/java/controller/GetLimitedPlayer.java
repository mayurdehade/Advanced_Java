package controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

import entity.Player;
import hibernateconfig.HibernateConfigure;

public class GetLimitedPlayer {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateConfigure.getSessionFactory();
		
		Session sesn = sessionFactory.openSession();
		
		Criteria criteria = sesn.createCriteria(Player.class);
		
		criteria.setMaxResults(5);
		criteria.addOrder(Order.desc("runs"));
		
		List<Player> list = criteria.list();
		
		for (Player player : list) {
			System.out.println(player);
		}
		
	}

}
