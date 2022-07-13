package com.revature.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

 
	@Retention(RUNTIME)
	@Target(FIELD)
	public @interface FkRelation {
		String columnName() default "";
		String referencesTo()  default ""; //has to be a PK of the referenced to
		String tableNameRefTo() default ""; //has to be the table name of that PK
	}

 
