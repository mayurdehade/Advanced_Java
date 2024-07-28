package controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import entity.Player;
import hibernateconfig.HibernateConfigure;

public class RestrictionsExample {

	public static void main(String[] args) {
		SessionFactory sf = HibernateConfigure.getSessionFactory();

		Session sess = sf.openSession();

		Criteria criteria = sess.createCriteria(Player.class);

		// runs equal to 20000
//		criteria.add(Restrictions.eq("runs",20000));

		// runs between 100 to 20000
//		criteria.add(Restrictions.between("runs", 100, 20000));
		
		//runs greater than 20000
//		criteria.add(Restrictions.gt("runs", 20000));
		
		//runs less than 20000
//		criteria.add(Restrictions.lt("runs", 20000));
		
		//Player name start with r
//		criteria.add(Restrictions.like("playername", "r%"));
		
		
		//multiple condition 
		
		
		
		List<Player> players = criteria.list();

		for (Player player : players) {
			System.out.println(player);
		}

	}

}
