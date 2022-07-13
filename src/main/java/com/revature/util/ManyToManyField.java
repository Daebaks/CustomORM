package com.revature.util;

import java.lang.reflect.Field;

import com.revature.annotations.Column;
import com.revature.annotations.ManyToMany;

public class ManyToManyField {

	private Field field;
	
	public ManyToManyField(Field field) {
		
		
		if(field.getAnnotation(ManyToMany.class) == null) {
			throw new IllegalStateException("Cannot create ManyToManyField object! Provided field: "
					+ getName() + "is not annotated with @ManyToMany");
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
	public String getTableMappedTo() {
	return field.getAnnotation(ManyToMany.class).tableMappedTo();
}
	public String getTableMappedFrom() {
		return field.getAnnotation(ManyToMany.class).tableMappedFrom();
	}
	public String getFkTo() {
		return field.getAnnotation(ManyToMany.class).fkTo();
	}
	public String getFkFrom() {
		return field.getAnnotation(ManyToMany.class).fkFrom();
	}
}