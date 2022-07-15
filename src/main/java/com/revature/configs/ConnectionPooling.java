package com.revature.configs;

import java.sql.Connection;
import java.sql.SQLException;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionPooling {

	private static HikariDataSource ds=new HikariDataSource();
	
	private ConnectionPooling() {
		//default empty constructor
	}
	
	public static void setDriver(String dr) {
		ds.setDriverClassName(dr);
	}
	
	public static void setConnectionTimeout(long time) {
		ds.setConnectionTimeout(time);
	}
	
	public static void setMaxLifetime(long maxlife) {
		ds.setMaxLifetime(maxlife);
	}
	
	public static void setAutoCommit(boolean auto) {
		ds.setAutoCommit(auto);
	}
	
	public static void setIdleTimeout(long idle) {
		ds.setIdleTimeout(idle);
	}
	
	public static void setUrl(String url) {
		ds.setJdbcUrl(url);
		
	}
	public static void setUsername(String user) {
		ds.setUsername(user);
	}
	public static void setPassword(String pass) {
		ds.setPassword(pass);
	 
	}
	public static void setSchema(String schema) {
		ds.setSchema(schema);
	}
	
	public static void closeConn() {
		ds.close();
	}
	
	public static Connection getConn() throws SQLException {
		return ds.getConnection();
	}
	
}
