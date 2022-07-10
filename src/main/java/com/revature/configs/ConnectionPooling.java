package com.revature.configs;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionPooling {

	private static HikariConfig config = new HikariConfig();
	private static HikariDataSource ds=new HikariDataSource(config);
	
	private ConnectionPooling() {}
	
	public static void setUrl(String url) {
		config.setJdbcUrl(url);
	}
	public static void setUsername(String user) {
		 config.setUsername(user);
	}
	public static void setPassword(String pass) {
		 config.setPassword(pass);
	 
	}
	public static void setSchema(String schema) {
		 config.setSchema(schema);
	}
	
	public static void closeConn() {
		 ds.close();
	}
	
	public static Connection getConn() throws SQLException {
		
		return ds.getConnection();
	}
	
	
	
}
