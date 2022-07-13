package com.revature.demoapp.daos;

import java.util.List;

import com.revature.demoapp.models.Pokemon;

public class PokemonDAO {

	public int insert(Pokemon poke) {

		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();

		int pk = (int) ses.save(poke);

		tx.commit();
		return pk; // reutrn the auto-generated PK
	}

	// select all
	public List<Pokemon> selectAll() {

		// HQL - Hibernate Query Language

		Session ses = HibernateUtil.getSession();

		/**
		 * HQL Hibernate Query Language
		 * Combo of SQL and OOP
		 */
		List<Pokemon> villList = ses.createQuery("from Pokemon", Pokemon.class).list();
		// HQL will return instances of the SuperVillain.java class

		return villList;
	}

	public Pokemon selectByName(String name) {

		Session ses = HibernateUtil.getSession();
		/**
		 * Native SQL querying
		 */
//		SuperVillain vill = (SuperVillain) ses.createNativeQuery("SELECT * FROM super_villains WHERE svill_name = '" +name+ "'", SuperVillain.class);

		/**
		 * Criteria API
		 */
//		SuperVillain vill = (SuperVillain) ses.createCriteria(SuperVillain.class).add(Restrictions.like("svill_name", name));

		/**
		  * HQL - Hibernate Query Language 
		  * */
		Pokemon poke = (Pokemon) ses.createQuery("from Pokemon where name = '" +name+"'", Pokemon.class);


		return poke;
	}

	public void update(Pokemon poke) {

		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();

		ses.update(poke);

		tx.commit();
	}

}
