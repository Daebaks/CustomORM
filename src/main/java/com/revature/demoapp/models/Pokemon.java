package com.revature.demoapp.models;

import java.util.Objects;

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

	public int getPokemonId() {
		return pokemonId;
	}

	
	public Pokemon(String power, int rewardPoints, String locationCaught) {
		super();
		this.power = power;
		this.rewardPoints = rewardPoints;
		this.locationCaught = locationCaught;
	}

	
	public void setPokemonId(int pokemonId) {
		this.pokemonId = pokemonId;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public int getRewardPoints() {
		return rewardPoints;
	}

	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	public String getLocationCaught() {
		return locationCaught;
	}

	public void setLocationCaught(String locationCaught) {
		this.locationCaught = locationCaught;
	}

	@Override
	public int hashCode() {
		return Objects.hash(locationCaught, pokemonId, power, rewardPoints);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		return Objects.equals(locationCaught, other.locationCaught) && pokemonId == other.pokemonId
				&& Objects.equals(power, other.power) && rewardPoints == other.rewardPoints;
	}

	@Override
	public String toString() {
		return "Pokemon [pokemonId=" + pokemonId + ", power=" + power + ", rewardPoints=" + rewardPoints
				+ ", locationCaught=" + locationCaught + "]";
	}
	
	
	
}
