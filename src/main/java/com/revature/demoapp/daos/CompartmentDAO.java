package com.revature.demoapp.daos;

import com.revature.demoapp.models.Compartment;
import com.revature.helpers.Session;

public class CompartmentDAO {
	
	public int insert(Compartment cp) {

		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();

		int pk = (int) ses.save(cp);

		tx.commit();

		return pk;

	}

	
	public Compartment selectById(int id) {

		
		Session ses = HibernateUtil.getSession();

		
		Compartment cp = ses.get(Compartment.class, id);

		return cp;
	}

}
