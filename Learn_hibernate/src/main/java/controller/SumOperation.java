package controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import entity.Player;
import hibernateconfig.HibernateConfigure;

public class SumOperation {

	public static void main(String[] args) {
		SessionFactory sf = HibernateConfigure.getSessionFactory();
		Session sesn = sf.openSession();
		
		Criteria criteria = sesn.createCriteria(Player.class);
		
		//sum of total runs
		criteria.setProjection(Projections.sum("runs"));
		
		List<Long> runs = criteria.list();
		
		if(runs.isEmpty()) {
			System.out.println(0);
		}
		else {
			long run = runs.get(0);
			System.out.println(run);
		}
	}

}
