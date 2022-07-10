package com.revature.helpers;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.configs.DbConfig;

//this will help creating the DB tables and entities
public class DbHelper {

	
	DbConfig cfg = new DbConfig();
	
	
	public void createDb() {
		try(Connection conn = cfg.getConnection()) {
			//here: SQL DB creation for the current connection
			//here I will get the annotates classes, make new metaClassModels for them, extract the info, then build the DB
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
