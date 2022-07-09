package com.revature.util;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

import com.revature.annotations.Column;
import com.revature.annotations.FkRelation;
import com.revature.annotations.Id;
import com.revature.annotations.Table;
 
public class MetaClassModel<T> {

	private Class<?> clazz;
	private PkField pkField;
	private List<ColumnField> columnFields;
	private List<FkField> fkField;
	
	
	
	public MetaClassModel(Class<?> clazz) {
		this.clazz  = clazz;
		this.columnFields = new LinkedList<>();
		this.fkField = new LinkedList<>();
	}

	public static MetaClassModel<Class<?>> of(Class<?> clazz){
	
		if (clazz.getAnnotation(Table.class) == null) {
			throw new IllegalStateException("Cannot create MetaModel Object! Provided Class: " + clazz.getName() +
											" is not annotated with @Entity");
		}
		
		return new MetaClassModel<>(clazz);
	}
	
	public List<ColumnField> getColumns(){
		
		
		Field[] fields = clazz.getDeclaredFields();
		
		for (Field field: fields) {
			
			// Create a column object, this will not be null if the field is annotated with @Column
			Column column = field.getAnnotation(Column.class);
			
			if (column != null) {
				// This means it's marked with @column and we can add it to our list
				columnFields.add(new ColumnField(field));
			}
		}
		
		if(columnFields.isEmpty()) {
			throw new RuntimeException("No columns found in: " + clazz.getName());
		}
		
		return columnFields;
	}
	
	// Let's do the foreign key field first since this should match almost exactly to our getColumnFields
	
	public List<FkField> getForeignKeys(){
		
		// This method return all the properties of the class that are marked with @Column
		
				Field[] fields = clazz.getDeclaredFields();
				
				for (Field field: fields) {
					
					FkRelation foreignKey = field.getAnnotation(FkRelation.class);
					
					if (foreignKey != null) {
						fkField.add(new FkField(field));
					}
				}
				
				
				if(fkField.isEmpty()) {
					throw new RuntimeException("No foreign keys found in: " + clazz.getName());
				}
				
				return fkField;
		
	}
	
	
	public PkField getPrimaryKey() {
		
		// Capture an array of the fields
		Field[] fields = clazz.getDeclaredFields();
		
		// Check for primary key
		for (Field field: fields) {
			Id primaryKey = field.getAnnotation(Id.class);
			
			
			if (primaryKey != null) {
				// This will capture the first and (hopefully) only primary key that exists
				return new PkField(field);
			}
		}
		
		throw new RuntimeException("Did not find a field annotated with @Id in class: " + clazz.getName());
	}
	
	public String getSimpleClassName() {
		return clazz.getSimpleName();
	}
	
	public String getClassName() {
		return clazz.getName();
	}
	
}
