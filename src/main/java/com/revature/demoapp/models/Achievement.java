package com.revature.demoapp.models;

import java.util.Objects;

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


	public Achievement(int achievementId, String achievementName, String achievementDescription) {
		super();
		this.achievementId = achievementId;
		this.achievementName = achievementName;
		this.achievementDescription = achievementDescription;
	}


	public Achievement(String achievementName, String achievementDescription) {
		super();
		this.achievementName = achievementName;
		this.achievementDescription = achievementDescription;
	}


	@Override
	public String toString() {
		return "Achievement [achievementId=" + achievementId + ", achievementName=" + achievementName
				+ ", achievementDescription=" + achievementDescription + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(achievementDescription, achievementId, achievementName);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Achievement other = (Achievement) obj;
		return Objects.equals(achievementDescription, other.achievementDescription)
				&& achievementId == other.achievementId && Objects.equals(achievementName, other.achievementName);
	}


	public int getAchievementId() {
		return achievementId;
	}


	public void setAchievementId(int achievementId) {
		this.achievementId = achievementId;
	}


	public String getAchievementName() {
		return achievementName;
	}


	public void setAchievementName(String achievementName) {
		this.achievementName = achievementName;
	}


	public String getAchievementDescription() {
		return achievementDescription;
	}


	public void setAchievementDescription(String achievementDescription) {
		this.achievementDescription = achievementDescription;
	}
	
	
	
	
}
