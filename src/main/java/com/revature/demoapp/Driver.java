package com.revature.demoapp;

import java.util.ArrayList;
import java.util.List;

import com.revature.configs.DbConfig;
import com.revature.demoapp.models.Achievement;
import com.revature.demoapp.models.Compartment;
import com.revature.demoapp.models.Pokemon;
import com.revature.helpers.Session;

public class Driver {

	public static void main(String[] args) {

		DbConfig conf = new DbConfig();
		conf.setXmlPath("C:\\Users\\Nothing\\Desktop\\SpringToolsWorkSpace\\project1\\src\\main\\resources\\myorm.cfg.xml");
		conf.setupConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres95");
		conf.setSchema("orm");
		conf.buildDb();

		// TESTING//
		Session s = new Session();
		
		
		
        /*insertion*/
//		Achievement ach1 = new Achievement("Killing the monster","Killed a very huge monster who was destroying the city");
//		Achievement ach2 = new Achievement("Gained","Worked and searched for a super power unitl they got it");
//		Achievement ach3 = new Achievement("Changed color","Realized how to use their super power to change color to hide");
 
//		List<Achievement> achlist = new ArrayList<Achievement>();
//		achlist.add(ach1);
//		achlist.add(ach2);
//		achlist.add(ach3);
		
		/*insert 3 achievements*/
//		for(Achievement a : achlist) {
//			s.insertToDb(a);
//		}
//		
		
//		Compartment comp = new Compartment("pokemon container", "Somewhere in mystery land", 1000);
		
		/*insert 1 compartment returning the generated ID*/
//		System.out.println(s.insertToDb(comp));
		
		
//		Pokemon pok1 = new Pokemon("Poki", "Very strong",1500,"Nice land",comp, achlist );
		
		/*insert 1 pokemon*/
//       s.insertToDb(pok1);
         
//         Pokemon pok2 = new Pokemon("Poki2", "Beautiful",1200,"Nice land",comp, achlist );
         
 		/*insert 2nd pokemon*/
//      s.insertToDb(pok2);
         
          
          
          
          
          
         /*Deleting*/
//		Pokemon pokToDelete = new Pokemon();
// 		pokToDelete.setPokemonId(3);
//		s.deleteFromDb(pokToDelete);

//		Achievement achToDelete = new Achievement();
//		achToDelete.setAchievementId();
//		s.deleteFromDb(achToDelete);

		
		
		/*reading*/
//		Compartment cToRead = new Compartment();
//		cToRead.setCompartmentId(1);
//		s.readFromDb(cToRead);
		
//		Achievement achToRead = new Achievement();
//		achToRead.setAchievementId();
//		s.readFromDb(achToRead);
		
	}
}
