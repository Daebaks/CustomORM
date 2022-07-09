package com.revature.configs;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.revature.util.MetaClassModel;

public class DbConfig {

	private String dbUrl;
	private String dbUserNmae;
	private String dbPassword;
	private String dbSchema;
	private Connection conn;
	
	private List<MetaClassModel<Class<?>>> metaClassModelList;

	public DbConfig addAnnotatedClass(Class annotatedClass) {
		if(metaClassModelList == null) {
			metaClassModelList = new LinkedList<>();
		}
		metaClassModelList.add(MetaClassModel.of(annotatedClass));		
		return this;
	}
	
	public List<MetaClassModel<Class<?>>> getMetaClassModelList(){
		return (metaClassModelList == null) ? Collections.emptyList() : metaClassModelList;
	}
	
	public void setupConnection(String dnUrl, String dbUsername, String dbPassword ) {
		ConnectionPooling.setUrl(dnUrl);
		ConnectionPooling.setUsername(dbUsername);
		ConnectionPooling.setPassword(dbPassword);
	}
	public void setupConnection(String dnUrl, String dbUsername, String dbPassword, String dbSchema ) {
		ConnectionPooling.setUrl(dnUrl);
		ConnectionPooling.setUsername(dbUsername);
		ConnectionPooling.setPassword(dbPassword);
		ConnectionPooling.setSchema(dbSchema);
	}
	 
	public Connection getConnection() throws SQLException {
		if(ConnectionPooling.getConn() == null) {
			throw new SQLException("Connection Failed!");
		} else {
			conn = ConnectionPooling.getConn();
		}
		return conn;
	}
}
