package controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import entity.Player;
import hibernateconfig.HibernateConfigure;

public class MultipleSpecificColumns {

	public static void main(String[] args) {
		SessionFactory sf = HibernateConfigure.getSessionFactory();
		
		Session sesn = sf.openSession();
		Criteria criteria = sesn.createCriteria(Player.class);
		
		//for add multiple properties use projectionList
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("playerid"));
		projectionList.add(Projections.property("playername"));
		
		criteria.setProjection(projectionList);
		
		List<Object[]> object = criteria.list();
		
		for (Object[] obj : object) {
			System.out.println(obj[0]+"\t"+obj[1]);
		}
	}

}
