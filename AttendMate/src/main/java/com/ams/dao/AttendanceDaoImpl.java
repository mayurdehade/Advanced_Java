package com.ams.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ams.entity.Attendance;

@Repository
public class AttendanceDaoImpl implements AttendanceDao {
	
	@Autowired
	private SessionFactory factory;

	@Override
	public String takeAttendance(Attendance attendance) {
		Session session = null;
		String msg = "";
		try {
			session = factory.openSession();
			session.save(attendance);
			session.beginTransaction().commit();
			msg = "Attendance recorded...";
		} catch (Exception e) {
			e.printStackTrace();
			msg = "Something went wrong while taking attendance";
		} finally {
			session.close();
		}
		return msg;
	}

	@Override
	public List<Attendance> showAttendance() {
		Session session = null;
		List<Attendance> attendance = null;
		try {
			session = factory.openSession();
			Criteria criteria = session.createCriteria(Attendance.class);
			attendance = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return attendance;
	}

}
