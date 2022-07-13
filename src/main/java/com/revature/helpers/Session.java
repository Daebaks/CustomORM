package com.revature.helpers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.revature.configs.DbConfig;
import com.revature.util.ColumnField;
import com.revature.util.FkField;
import com.revature.util.MetaClassModel;

public class Session<T> {

	DbConfig d = new DbConfig();

	public int insertToDb(Object obj) {

		//Extracting the metaClassModel from the object.
		MetaClassModel<Class<?>> theClass = MetaClassModel.of(obj.getClass());
		System.out.println(theClass.getTableName());
		//Getting the values from the given obj
		//List<Object>  values = new LinkedList<>();
		
		//Getting to know the obj
		List<ColumnField> columns = theClass.getColumns();
		List<FkField> foreignFieldsColumns = theClass.getForeignKeys();
		
		//Building the sql string
		StringBuilder sql = new StringBuilder();
		
//		if(!columns.isEmpty()) {
//			for()
//		}
		
//		try (Connection conn = d.getConnection()) {
//			// here, inserting an obj into a row implementation. Returns the PK identifier
//			// value for the inserted obj for the ORM
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		return -1;

	}

	public void deleteFromDb(Object obj) {

	}

	public void updateInDb(Object obj) {

	}

	public void readFromDb(Object obj) {

	}
}
