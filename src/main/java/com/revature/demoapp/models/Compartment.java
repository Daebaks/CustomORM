package com.revature.demoapp.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.revature.annotations.Column;
import com.revature.annotations.Id;
import com.revature.annotations.Table;

@Table(tableName = "compartment")
public class Compartment {

	@Id(columnName = "compartmentid")
	private int compartmentId;
	
	@Column(columnName = "compartment_name")
	private String compartmentName;
	
	@Column(columnName = "compartment_address")
	private String compartmentLocation;
	
	@Column(columnName = "compartment_capacity")
	private int compartmentCapacity;
	
	//OneToMany
	private List<Pokemon> pokList = new ArrayList<Pokemon>();
	
	public Compartment() {
		super();
	}

	public Compartment(int compartmentId, String compartmentName, String compartmentLocation, int compartmentCapacity,
			List<Pokemon> pokList) {
		super();
		this.compartmentId = compartmentId;
		this.compartmentName = compartmentName;
		this.compartmentLocation = compartmentLocation;
		this.compartmentCapacity = compartmentCapacity;
		this.pokList = pokList;
	}

	public Compartment(String compartmentName, String compartmentLocation, int compartmentCapacity) {
		super();
		this.compartmentName = compartmentName;
		this.compartmentLocation = compartmentLocation;
		this.compartmentCapacity = compartmentCapacity;
	}

	public int getCompartmentId() {
		return compartmentId;
	}

	public void setCompartmentId(int compartmentId) {
		this.compartmentId = compartmentId;
	}

	public String getCompartmentName() {
		return compartmentName;
	}

	public void setCompartmentName(String compartmentName) {
		this.compartmentName = compartmentName;
	}

	public String getCompartmentLocation() {
		return compartmentLocation;
	}

	public void setCompartmentLocation(String compartmentLocation) {
		this.compartmentLocation = compartmentLocation;
	}

	public int getCompartmentCapacity() {
		return compartmentCapacity;
	}

	public void setCompartmentCapacity(int compartmentCapacity) {
		this.compartmentCapacity = compartmentCapacity;
	}

	public List<Pokemon> getPokList() {
		return pokList;
	}

	public void setPokList(List<Pokemon> pokList) {
		this.pokList = pokList;
	}

	@Override
	public int hashCode() {
		return Objects.hash(compartmentCapacity, compartmentId, compartmentLocation, compartmentName, pokList);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compartment other = (Compartment) obj;
		return compartmentCapacity == other.compartmentCapacity && compartmentId == other.compartmentId
				&& Objects.equals(compartmentLocation, other.compartmentLocation)
				&& Objects.equals(compartmentName, other.compartmentName) && Objects.equals(pokList, other.pokList);
	}

	@Override
	public String toString() {
		return "Compartment [compartmentId=" + compartmentId + ", compartmentName=" + compartmentName
				+ ", compartmentLocation=" + compartmentLocation + ", compartmentCapacity=" + compartmentCapacity + "]";
	}
	
	
	
}
