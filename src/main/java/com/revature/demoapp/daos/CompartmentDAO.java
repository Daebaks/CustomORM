package com.revature.demoapp.daos;

import com.revature.demoapp.models.Compartment;

public class CompartmentDAO {
	
	public int insert(Compartment cp) {

		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();

		int pk = (int) ses.save(cp);

		tx.commit();

		return pk;

	}

	// select By id
	public Compartment selectById(int id) {

		// we don't need a transaction since we're just querying data from the db
		Session ses = HibernateUtil.getSession();

		// session method - we are invoking a simple query to return an object of type SuperPrison with the PK that we specify from the SuperPrison table
		Compartment cp = ses.get(Compartment.class, id);

		return cp;
	}

}
