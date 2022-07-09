package com.revature.util;

import java.lang.reflect.Field;

import com.revature.annotations.Column;

public class ColumnField {

	private Field field;
	
	public ColumnField(Field field) {
		// Let's check the field to ensure it has the column annotation that we're expection
		
		if(field.getAnnotation(Column.class) == null) {
			throw new IllegalStateException("Cannot create ColumnField object! Provided field: "
					+ getName() + "is not annotated with @Column");
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
		return field.getAnnotation(Column.class).columnName();
	}

}
