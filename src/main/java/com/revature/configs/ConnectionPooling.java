package com.revature.configs;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.pool.HikariPool;

public class ConnectionPooling {

//	private static HikariConfig config = new HikariConfig();
	private static HikariDataSource ds=new HikariDataSource();
	
	static {
        ds.setAutoCommit(false);
        ds.setMaximumPoolSize(10);
    }
	
	
	private ConnectionPooling() {}
	
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
