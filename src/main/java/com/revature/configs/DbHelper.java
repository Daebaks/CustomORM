package com.revature.configs;

import java.sql.Connection;
import java.sql.SQLException;

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
