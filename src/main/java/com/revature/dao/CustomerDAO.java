package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Customer;
import com.revature.util.HibernateUtility;

public class CustomerDAO {
	
	public int insert(Customer c) {

		Session s = HibernateUtility.getSession();
		Transaction tx = s.beginTransaction();
		int pk = (int) s.save(c);
		tx.commit();

		return pk;
	}

	public List<Customer> findAll(){
		Session s = HibernateUtility.getSession();
		return s.createQuery("from Customer", Customer.class).list();
	}
	
	public Customer findByUserName(String u) {
		Session s = HibernateUtility.getSession();
		Customer customer = (Customer) s.createQuery("from Customer where name = '" +u+"'", Customer.class);
		return customer;
	}

	public boolean update(Customer c) {
		Session s = HibernateUtility.getSession();
		Customer customer = (Customer) s.createQuery("from Customer", Customer.class).list();
		return false;
	}

	public boolean delete(Customer id) {
		Session s = HibernateUtility.getSession();
		Customer customer = (Customer) s.createQuery("from Customer where customerId = ", Customer.class);
		return false;
	}
}
