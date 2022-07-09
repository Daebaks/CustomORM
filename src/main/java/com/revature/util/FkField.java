package com.revature.util;

import java.lang.reflect.Field;

import com.revature.annotations.FkRelation;

public class FkField {
private Field field;
	
	public FkField(Field field) {
		
		if(field.getAnnotation(FkRelation.class) == null) {
			throw new IllegalStateException("Cannot create ForeignKeyField object! Provided field: "
					+ getName() + "is not annotated with @JoinColumn");
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
	
	public String getColumnName() {
		return field.getAnnotation(FkRelation.class).columnName();
	}
}
