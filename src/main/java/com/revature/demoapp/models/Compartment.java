package com.revature.demoapp.models;

import java.util.ArrayList;
import java.util.List;


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
	
	
}
