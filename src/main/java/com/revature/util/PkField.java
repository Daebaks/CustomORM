package com.revature.util;

import java.lang.reflect.Field;

import com.revature.annotations.Id;

public class PkField {

private Field field;
	
	public PkField(Field field) {
		// Let's check the field to ensure it has the column annotation that we're expecting
		
		if(field.getAnnotation(Id.class) == null) {
			throw new IllegalStateException("Cannot create PrimaryKeyField object! Provided field: "
					+ getName() + "is not annotated with @Id");
		}
		
		this.field = field;
		
	}
	
	public String getName() {
		return field.getName();
	}
	
	// Return the type of the field that annotated
	public Class<?> getType(){
		return field.getType();
	}
	// Let's add one final method to extract the column so we can utilize if we're building sql tables
	public String getColumnName() {
		return field.getAnnotation(Id.class).columnName();
	}
}
