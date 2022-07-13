package com.revature.demoapp.models;

import com.revature.annotations.Column;
import com.revature.annotations.Id;
import com.revature.annotations.Table;

@Table(tableName = "achievement")
public class Achievement {

	@Id(columnName = "achievementid")
	private int achievementId;
	
	@Column(columnName = "achievement_name")
	private String achievementName;
	
	@Column(columnName = "achievement_desc")
	private String achievementDescription;
	
	
	public Achievement() {
		super();
	}
	
	
}
