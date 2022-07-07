package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Ticket;
import com.revature.util.HibernateUtility;

public class TicketDAO {
	
	public int insert(Ticket e) {

		// Grab the session object
		Session ses = HibernateUtility.getSession(); // Session in the context of JDBC connection

		// begin a tx
		Transaction tx = ses.beginTransaction(); // import Transaction from Hibernate, NOT the JPA

		// capture the pk returned from save()
		int pk = (int) ses.save(e);

		// commit the tx
		tx.commit();

		// return the pk
		return pk;
	}

	public List<Ticket> findAll(){

		// grab the session
		Session ses = HibernateUtility.getSession();

		// make a HQL statement to return all records from the Ticket table - mix of SQL & OOP
		List<Ticket> tix = ses.createQuery("from Ticket", Ticket.class).list();

		// there's also Criteria API & Native SQL are other ways to write complex queries

		// return that list
		return tix;
	}

	public boolean update(Ticket e) {
		
		Session ses = HibernateUtility.getSession();
		
		return false;
	}

	public boolean delete(Ticket e) {
		
		Session ses = HibernateUtility.getSession();
		
		return false;
	}

}