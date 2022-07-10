package com.revature.helpers;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.configs.DbConfig;

//this will help creating the DB tables and entities
public class DbHelper {

	
	DbConfig cfg = new DbConfig();
	
	
	public void createDb() {
		try(Connection conn = cfg.getConnection()) {
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
