package controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import entity.Player;
import hibernateconfig.HibernateConfigure;

public class NumberOfPlayers {

	public static void main(String[] args) {
		SessionFactory sf = HibernateConfigure.getSessionFactory();
		
		Session sesn = sf.openSession();
		
		Criteria criteria = sesn.createCriteria(Player.class);
		
		//row count
		criteria.setProjection(Projections.rowCount());
		
		List<Integer> list = criteria.list();
		
		if(list.isEmpty()) {
			System.out.println(0);
		} else {
			System.out.println(list.get(0));
		}
		
	}

}
