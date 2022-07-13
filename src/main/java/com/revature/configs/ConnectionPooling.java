package com.revature.configs;

import java.sql.Connection;
import java.sql.SQLException;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionPooling {

	private static HikariDataSource ds=new HikariDataSource();
	
	static {
//		ds.setAutoCommit(false);
//		ds.setConnectionTimeout(30000);
//		ds.setIdleTimeout(600000);
//		ds.setMaxLifetime(1800000);
        ds.setDriverClassName("org.postgresql.Driver");        
    }
		
	private ConnectionPooling() {
		
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
