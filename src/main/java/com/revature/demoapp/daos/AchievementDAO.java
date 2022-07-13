package com.revature.demoapp.daos;

import com.revature.demoapp.models.Achievement;
import com.revature.helpers.Session;

public class AchievementDAO {
	
	public void insertWIhtoutCasting(Achievement ach) {

		// capture a session
		Session ses = HibernateUtil.getSession();

		// Transaction is uniquely from HIbernate
		Transaction tx = ses.beginTransaction();

		// Make sure that you have java 8 set in your properties in Maven
		// the save() method reutrns the Primary Key
		ses.save(ach); 
		tx.commit();

	}

	public int insert(Achievement ach) {

		// capture a session
		Session ses = HibernateUtil.getSession();

		// Transaction is uniquely from HIbernate
		Transaction tx = ses.beginTransaction();

		// Make sure that you have java 8 set in your properties in Maven
		int pk = (int) ses.save(ach); // the save() method reutrns the Primary Key

		tx.commit();

		return pk; // we return the generate Primary Key that DB provides for us
	}

}
