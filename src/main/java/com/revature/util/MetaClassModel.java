package com.revature.util;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

import com.revature.annotations.Column;
import com.revature.annotations.FkRelation;
import com.revature.annotations.Id;
import com.revature.annotations.ManyToMany;
import com.revature.annotations.Table;
 
public class MetaClassModel<T> {

	private Class<?> clazz;
	private PkField pkField;
	private List<ColumnField> columnFields;
	private List<FkField> fkFields;
	private List<ManyToManyField> mTmFields;
	
	public MetaClassModel(Class<?> clazz) {
		this.clazz  = clazz;
		this.columnFields = new LinkedList<>();
		this.fkFields = new LinkedList<>();
		this.mTmFields = new LinkedList<>();
	}

	public static MetaClassModel<Class<?>> of(Class<?> clazz){
	
		if (clazz.getAnnotation(Table.class) == null) {
			throw new IllegalStateException("Cannot create MetaModel Object! Provided Class: " + clazz.getName() +
											" is not annotated with @Table");
		}
		
		return new MetaClassModel<>(clazz);
	}
	
	
	public List<ColumnField> getColumns(){
		
		columnFields.clear();
		Field[] fields = clazz.getDeclaredFields();
		
		for (Field field: fields) {
			
			Column column = field.getAnnotation(Column.class);
			
			if (column != null) {
				columnFields.add(new ColumnField(field));
			}
		}
		
		if(columnFields.isEmpty()) {
			throw new RuntimeException("No columns found in: " + clazz.getName());
		}
		
		return columnFields;
	}
	
	public List<FkField> getForeignKeys(){
	
				Field[] fields = clazz.getDeclaredFields();
				fkFields.clear();
				for (Field field: fields) {
					
					FkRelation foreignKey = field.getAnnotation(FkRelation.class);
					if (foreignKey != null) {
						fkFields.add(new FkField(field));
					}
				}
//				if(fkFields.isEmpty()) {
//					throw new RuntimeException("No foreign keys found in: " + clazz.getName());
//				}
				
				return fkFields;
	}
	
	public List<ManyToManyField> getMTMfields(){
		
		Field[] fields = clazz.getDeclaredFields();
		mTmFields.clear();
		for (Field field: fields) {
			
			ManyToMany mTm = field.getAnnotation(ManyToMany.class);
			if (mTm != null) {
				mTmFields.add(new ManyToManyField(field));
			}
		}
//		if(fkFields.isEmpty()) {
//			throw new RuntimeException("No foreign keys found in: " + clazz.getName());
//		}
		
		return mTmFields;
}
	
	public PkField getPrimaryKey() {
		Field[] fields = clazz.getDeclaredFields();
		for (Field field: fields) {
			Id pkField = field.getAnnotation(Id.class);
			if (pkField != null) {
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
	
	public Class<?> getTheClass() {
		return clazz;
	}
	
	
}
