package com.revature.demoapp;

import com.revature.configs.DbConfig;
import com.revature.demoapp.models.Achievement;
import com.revature.demoapp.models.Compartment;
import com.revature.helpers.Session;

public class Driver{

public static void main(String[] args) {
		
		DbConfig conf = new DbConfig();
		conf.setXmlPath("C:\\Users\\Nothing\\Desktop\\SpringToolsWorkSpace\\project1\\src\\main\\resources\\myorm.cfg.xml");
		conf.setupConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres95");
		conf.setSchema("orm");
		conf.buildDb();
		
		//TESTING
		Session s = new Session();
		
		Achievement ach = new Achievement("Killing the monster", "Killed a very huge monster who was destroying the city at the time");
		Compartment com = new Compartment();
		
		s.insertToDb(ach);
				
		
		//TESTING
}
}
