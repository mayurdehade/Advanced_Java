package controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import entity.Player;
import hibernateconfig.HibernateConfigure;

public class MaxOperation {

	public static void main(String[] args) {
		SessionFactory sf = HibernateConfigure.getSessionFactory();
		
		Session sesn = sf.openSession();
		
		Criteria criteria = sesn.createCriteria(Player.class);
		criteria.setProjection(Projections.max("runs"));
		
		List maxRuns = criteria.list();
		
		if (maxRuns.isEmpty()) {
			System.out.println(0);
		} else {
			System.out.println(maxRuns.get(0));
		}
	}

}
