package com.revature.util;

import java.lang.reflect.Field;

import com.revature.annotations.Table;

public class TableField {
 
private Field field;
	
	public TableField(Field field) {
		
		
		if(field.getAnnotationsByType(Table.class) == null) {
			throw new IllegalStateException("Cannot create ColumnField object! Provided field: "
					+ getName() + "is not annotated with @Column");
		}
		
		this.field = field;
		
	}
	
	public String getName() {
		return field.getName();
	}
	
 	public Class<?> getType(){
		return field.getType();
	}
	
	
	public String getTableName() {
		return field.getAnnotation(Table.class).tableName();
	}
	
	
}
