package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.configs.DbConfig;

public class Main {
	
	public static void main(String[] args) {
		DbConfig conf = new DbConfig();
		conf.setXmpPath("C:\\Users\\Nothing\\Desktop\\SpringToolsWorkSpace\\project1\\src\\main\\resources\\myorm.cfg.xml");
		conf.setupConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres95");
		conf.setSchema("project1");
		conf.buildDb();
		
		
		
		
	

}
}