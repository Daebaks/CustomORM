package com.revature.demoapp.models;

import java.util.List;
import java.util.Objects;

import com.revature.annotations.Column;
import com.revature.annotations.FkRelation;
import com.revature.annotations.Id;
import com.revature.annotations.ManyToMany;
import com.revature.annotations.Table;

@Table(tableName = "pokemon")
public class Pokemon {
 
	@Id(columnName = "pokemonid")
	private int pokemonId;
	
	@Column(columnName = "pokemon_name")
	private String pokemonName;
	
	@Column(columnName = "pokemon_power")
	private String power;
	
	@Column(columnName = "reward_points")
	private int rewardPoints;
	
	@Column(columnName = "location_caught")
	private String locationCaught;

	//ManyToOne
	@FkRelation(columnName = "compart_fk", referencesTo = "compartmentid", tableNameRefTo = "compartment")
	private Compartment compFK;
	
	@ManyToMany(fkFrom = "pokemonid", fkTo = "achievementid", tableMappedFrom = "pokemon", tableMappedTo = "achievement")
	private List<Achievement> achievList;
	
	public Pokemon() {
		super();
	}

	public int getPokemonId() {
		return pokemonId;
	}

	
	

	public Pokemon(String pokemonName, String power, int rewardPoints, String locationCaught, Compartment compFK,
			List<Achievement> achievList) {
		super();
		this.pokemonName = pokemonName;
		this.power = power;
		this.rewardPoints = rewardPoints;
		this.locationCaught = locationCaught;
		this.compFK = compFK;
		this.achievList = achievList;
	}

	public Pokemon(int pokemonId, String pokemonName, String power, int rewardPoints, String locationCaught,
			Compartment compFK, List<Achievement> achievList) {
		super();
		this.pokemonId = pokemonId;
		this.pokemonName = pokemonName;
		this.power = power;
		this.rewardPoints = rewardPoints;
		this.locationCaught = locationCaught;
		this.compFK = compFK;
		this.achievList = achievList;
	}

	public Pokemon(String pokemonName, String power, int rewardPoints, String locationCaught, Compartment compFK) {
		super();
		this.pokemonName = pokemonName;
		this.power = power;
		this.rewardPoints = rewardPoints;
		this.locationCaught = locationCaught;
		this.compFK = compFK;
	}

	@Override
	public int hashCode() {
		return Objects.hash(achievList, compFK, locationCaught, pokemonId, pokemonName, power, rewardPoints);
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
		return Objects.equals(achievList, other.achievList) && Objects.equals(compFK, other.compFK)
				&& Objects.equals(locationCaught, other.locationCaught) && pokemonId == other.pokemonId
				&& Objects.equals(pokemonName, other.pokemonName) && Objects.equals(power, other.power)
				&& rewardPoints == other.rewardPoints;
	}

	public String getPokemonName() {
		return pokemonName;
	}

	public void setPokemonName(String pokemonName) {
		this.pokemonName = pokemonName;
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

	public Compartment getCompFK() {
		return compFK;
	}

	public void setCompFK(Compartment compFK) {
		this.compFK = compFK;
	}

	public List<Achievement> getAchievList() {
		return achievList;
	}

	public void setAchievList(List<Achievement> achievList) {
		this.achievList = achievList;
	}

	public void setPokemonId(int pokemonId) {
		this.pokemonId = pokemonId;
	}

	@Override
	public String toString() {
		return "Pokemon [pokemonId=" + pokemonId + ", pokemonName=" + pokemonName + ", power=" + power
				+ ", rewardPoints=" + rewardPoints + ", locationCaught=" + locationCaught + "]";
	}

	
	
	

	
}
