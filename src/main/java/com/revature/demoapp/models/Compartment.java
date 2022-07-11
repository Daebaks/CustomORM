package com.revature.demoapp.models;

import com.revature.annotations.Column;
import com.revature.annotations.Id;
import com.revature.annotations.Table;

@Table(tableName = "compartments")
public class Compartment {

	@Id(columnName = "compartment_id")
	private int compartmentId;
	
	@Column(columnName = "compartment_name")
	private String compartmentName;
	
	@Column(columnName = "compartment_address")
	private String compartmentLocation;
	
	@Column(columnName = "compartment_capacity")
	private int compartmentCapacity;
	
	public Compartment() {
		super();
	}
	
	
}
