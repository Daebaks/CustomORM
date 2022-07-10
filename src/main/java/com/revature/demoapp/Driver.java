package com.revature.demoapp;

import com.revature.configs.DbConfig;
import com.revature.demoapp.models.Pokemon;
import com.revature.util.MetaClassModel;

public class Driver {
public static void main(String[] args) {
	
	
	DbConfig c = new DbConfig();
	
	c.addAnnotatedClass(Pokemon.class);
	
	 for(MetaClassModel<?> clas : c.getMetaClassModelList()) {
		 
		 System.out.println(clas.getClassName());
		 System.out.println(clas.getPrimaryKey().getName());
		 System.out.println(clas.getColumns());
		 
	 }
	
}
}
