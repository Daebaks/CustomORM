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
		Transaction tr = s.beginTransaction();
		List<Movie> movs = s.createQuery("from Movie", Movie.class).list();
		tr.commit();
		return movs;
	}
	
	public Movie selectByName(String name) {
		Session s = HibernateUtility.getSession();
		Transaction tr = s.beginTransaction();
		Movie movie = (Movie) s.createQuery("from Movie where name = '" +name+"'", Movie.class);
		tr.commit();
		return movie;
	}
	
	public Movie selectById(int id) {
		Session s = HibernateUtility.getSession();
		Transaction tr = s.beginTransaction();
		Movie mov = (Movie) s.get(Movie.class, id);
		tr.commit();
		return mov;
	}
	
	public void deleteById(int id) {
		Session s = HibernateUtility.getSession();
		Transaction tr = s.beginTransaction();
		Movie movie = (Movie)s.load(Movie.class,id);
		s.delete(movie);
		tr.commit();
	}
	
	public void update(Movie movie) {
//		Session s = HibernateUtility.getSession();
//		Transaction tr = s.beginTransaction();
//		
//		s.update(movie);
//		tr.commit();
	}
	
	
	
}
