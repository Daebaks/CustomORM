package com.revature.demoapp.models;

import com.revature.annotations.Column;
import com.revature.annotations.Id;
import com.revature.annotations.Table;

@Table(tableName = "pokemons")
public class Pokemon {
 
	@Id(columnName = "pokemon_id")
	private int pokemonId;
	
	@Column(columnName = "power")
	private String power;
	
	@Column(columnName = "reward_points")
	private int rewardPoints;
	
	@Column(columnName = "location_caught")
	private String locationCaught;

	public Pokemon() {
		super();
	}
	
	
}
