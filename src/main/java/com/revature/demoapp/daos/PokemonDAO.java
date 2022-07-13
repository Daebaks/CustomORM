package com.revature.demoapp.daos;

import java.util.List;
import com.revature.helpers.Session;

import com.revature.demoapp.models.Pokemon;

public class PokemonDAO {

	public int insert(Pokemon poke) {

		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();

		int pk = (int) ses.save(poke);

		tx.commit();
		return pk;
	}

	
	public List<Pokemon> selectAll() {

		

		Session ses = HibernateUtil.getSession();

		
		List<Pokemon> pokeList = ses.createQuery("from Pokemon", Pokemon.class).list();
		

		return pokeList;
	}

	public Pokemon selectByName(String name) {

		Session ses = HibernateUtil.getSession();
		
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
