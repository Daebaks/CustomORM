package com.revature.demoapp.daos;

import com.revature.demoapp.models.Achievement;
import com.revature.helpers.Session;

public class AchievementDAO {
	
	public void insertWIhtoutCasting(Achievement ach) {

		
		Session ses = HibernateUtil.getSession();

		
		Transaction tx = ses.beginTransaction();

		
		ses.save(ach); 
		tx.commit();

	}

	public int insert(Achievement ach) {

		
		Session ses = HibernateUtil.getSession();

		
		Transaction tx = ses.beginTransaction();

		
		int pk = (int) ses.save(ach);

		tx.commit();

		return pk; 
	}

}
