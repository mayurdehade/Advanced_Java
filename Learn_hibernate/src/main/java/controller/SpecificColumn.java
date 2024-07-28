package controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import entity.Player;
import hibernateconfig.HibernateConfigure;

public class SpecificColumn {

	public static void main(String[] args) {
		SessionFactory sf = HibernateConfigure.getSessionFactory();
		
		Session sesn = sf.openSession();
		Criteria criteria = sesn.createCriteria(Player.class);
		
		criteria.setProjection(Projections.property("playername"));
		
		List list = criteria.list();
		
		for (Object object : list) {
			System.out.println(object);
		}
	}

}
