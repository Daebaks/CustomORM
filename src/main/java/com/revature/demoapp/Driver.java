package com.revature.demoapp;

import com.revature.configs.DbConfig;
import com.revature.helpers.Session;
import com.revature.demoapp.models.Achievement;

public class Driver{

public static void main(String[] args) {
		
		DbConfig conf = new DbConfig();
		conf.setXmlPath("C:\\Users\\ekajl\\Music\\project_1\\src\\main\\resources\\myorm.cfg.xml");
		conf.setupConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
		conf.setSchema("orm");
		conf.buildDb();
		
		//TESTING
		Session s = new Session();
		
		Achievement ach = new Achievement("Killing the monster", "Killed a very string monster who was destroying everything");
		
		s.insertToDb(ach);
		
				
		
		//TESTING
}
}
