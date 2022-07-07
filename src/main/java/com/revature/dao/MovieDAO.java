package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Movie;

import com.revature.util.HibernateUtility;

public class MovieDAO {

	public void insertWIhtoutCasting(Movie movie) {

		Session s = HibernateUtility.getSession();
		Transaction tr = s.beginTransaction();
		s.save(movie); 
		tr.commit();

	}
			
	public int insert(Movie movie) {
		Session s = HibernateUtility.getSession();
		Transaction tr = s.beginTransaction();
		int pk = (int) s.save(movie);
		tr.commit();
		return pk;
	}
	
	public List<Movie> selectAll(){
		Session s = HibernateUtility.getSession();
		return s.createQuery("from Movie", Movie.class).list();
	}
	
	public Movie selectByName(String name) {
		Session s = HibernateUtility.getSession();
		Movie movie = (Movie) s.createQuery("from Movie where name = '" +name+"'", Movie.class);
		return movie;
	}
	
	public Movie selectById(int id) {
		Session s = HibernateUtility.getSession();
		return s.get(Movie.class, id);
	}
	
	
	
	
}
