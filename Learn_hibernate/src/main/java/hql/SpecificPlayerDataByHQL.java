package hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import entity.Player;
import hibernateconfig.HibernateConfigure;

public class SpecificPlayerDataByHQL {

	public static void main(String[] args) {
		SessionFactory sf = HibernateConfigure.getSessionFactory();
		Session sesn = sf.openSession();
		
		Query<Object []> query = sesn.createQuery("select playerid, playername from Player");
		
		List<Object []> list = query.list();
		
		for (Object[] obj: list) {
			System.out.println(obj[0]+"\t"+obj[1]);
		}
	}

}
