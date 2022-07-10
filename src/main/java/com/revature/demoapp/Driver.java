package com.revature.demoapp;

import com.revature.demoapp.models.Pokemon;
import com.revature.helpers.AnnotatedClassesRetriever;

public class Driver {
public static void main(String[] args) {
	
 
	
	for(Class<?> c: AnnotatedClassesRetriever.getAnnotatedClassesList() ) {
		System.out.println(c.getSimpleName());
	}
	
//	DbConfig c = new DbConfig();
//	
//	c.addAnnotatedClass(Pokemon.class);
//	
//	 for(MetaClassModel<?> clas : c.getMetaClassModelList()) {
//		 
//		 System.out.println(clas.getClassName());
//		 System.out.println(clas.getPrimaryKey().getName());
//		 
//	 }
//	
}
}
