package com.revature.demoapp;

import com.revature.configs.DbConfig;

public class Driver{

public static void main(String[] args) {
		
		DbConfig conf = new DbConfig();
		conf.setXmlPath("C:\\Users\\Nothing\\Desktop\\SpringToolsWorkSpace\\project1\\src\\main\\resources\\myorm.cfg.xml");
		conf.setupConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres95");
		conf.setSchema("orm");
		conf.buildDb();
		
		
		 
}
}
