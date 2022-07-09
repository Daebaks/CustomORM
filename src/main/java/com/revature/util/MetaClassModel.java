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
	
	
	// Let's create a constructor that we'll only use when we call another method
	
	public MetaClassModel(Class<?> clazz) {
		this.clazz  = clazz;
		this.columnFields = new LinkedList<>();
		this.fkField = new LinkedList<>();
	}
	
	// Let's create a method to check and then transpose a normal java class to a MetaModel Class
	//  This means we need to check for the @Entity annotation
	
	public static MetaClassModel<Class<?>> of(Class<?> clazz){
		
		// Let's check for the @entity notation
		
		if (clazz.getAnnotation(Table.class) == null) {
			throw new IllegalStateException("Cannot create MetaModel Object! Provided Class: " + clazz.getName() +
											" is not annotated with @Entity");
		}
		
		return new MetaClassModel<>(clazz);
	}
	
	// We should create method to gather more data about our class
	// Let's find the column, primary key, and any foreign keys
	
	public List<ColumnField> getColumns(){
		
		// This method return all the properties of the class that are marked with @Column
		
		Field[] fields = clazz.getDeclaredFields();
		
		//for each field within the above field[] check to see if it has a column annotation and if it does,
		// add it to the metamodel's linked list
		
		for (Field field: fields) {
			
			// Create a column object, this will not be null if the field is annotated with @Column
			Column column = field.getAnnotation(Column.class);
			
			if (column != null) {
				// This means it's marked with @column and we can add it to our list
				columnFields.add(new ColumnField(field));
			}
		}
		
		// Let's just add some extra logic in the case that the entity doesn't have any column fields
		
		if(columnFields.isEmpty()) {
			throw new RuntimeException("No columns found in: " + clazz.getName());
		}
		
		return columnFields;
	}
	
	// Let's do the foreign key field first since this should match almost exactly to our getColumnFields
	
	public List<FkField> getForeignKeys(){
		
		// This method return all the properties of the class that are marked with @Column
		
				Field[] fields = clazz.getDeclaredFields();
				
				//for each field within the above field[] check to see if it has a column annotation and if it does,
				// add it to the metamodel's linked list
				
				for (Field field: fields) {
					
					// Create a column object, this will not be null if the field is annotated with @Column
					FkRelation foreignKey = field.getAnnotation(FkRelation.class);
					
					if (foreignKey != null) {
						// This means it's marked with @column and we can add it to our list
						fkField.add(new FkField(field));
					}
				}
				
				// Let's just add some extra logic in the case that the entity doesn't have any column fields
				
				if(fkField.isEmpty()) {
					throw new RuntimeException("No foreign keys found in: " + clazz.getName());
				}
				
				return fkField;
		
	}
	
	// Let's construct a method to extract out the primary key of a metamodel object
	
	public PkField getPrimaryKey() {
		
		// Capture an array of the fields
		Field[] fields = clazz.getDeclaredFields();
		
		// Check for primary key
		for (Field field: fields) {
			Id primaryKey = field.getAnnotation(Id.class);
			
			
			// If the primary key is not null then generate a primary key field object from that field
			if (primaryKey != null) {
				// This will capture the first and (hopefully) only primary key that exists
				return new PkField(field);
			}
		}
		
		throw new RuntimeException("Did not find a field annotated with @Id in class: " + clazz.getName());
	}
	
	// Just to make things simpler if we call this model
	
	public String getSimpleClassName() {
		return clazz.getSimpleName();
	}
	
	public String getClassName() {
		return clazz.getName();
	}
	
}
