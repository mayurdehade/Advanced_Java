package controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import entity.Player;
import hibernateconfig.HibernateConfigure;

public class OrOperation {

	public static void main(String[] args) {
		HibernateConfigure configure = new HibernateConfigure();

		SessionFactory sf = configure.getSessionFactory();

		Session sess = sf.openSession();

		Criteria criteria = sess.createCriteria(Player.class);

		SimpleExpression eqId = Restrictions.eq("playerid", 1);
		SimpleExpression eqRuns = Restrictions.ge("runs", 20000);
		criteria.add(Restrictions.or(eqId, eqRuns));

		List<Player> players = criteria.list();

		for (Player player : players) {
			System.out.println(player);
		}
	}

}
