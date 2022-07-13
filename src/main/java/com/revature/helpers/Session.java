package com.revature.helpers;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		Class<?> clays;
		clays = obj.getClass();
		MetaClassModel<Class<?>> theClass = MetaClassModel.of(obj.getClass());
		

		//Getting the values/types from the given obj
		List<T> values = new ArrayList<>();
		List<T> types = new ArrayList<>();

		
		//Getting to know the obj
		String tableName = theClass.getTableNameFromMetaClass();
		List<ColumnField> columns = theClass.getColumns();
		List<FkField> foreignFieldsColumns = theClass.getForeignKeys();
		
		//Building the sql string before loading values;
		StringBuilder sql_sb = new StringBuilder();
		sql_sb.append("INSERT INTO "+tableName+" ( ");
		for(int i=0; i<columns.size(); i++) {
			sql_sb.append(columns.get(i).getColumnName()+" ");
			try {
				Field valF = clays.getDeclaredField(columns.get(i).getName());
				//filling values.
						valF.setAccessible(true);
						values.add((T) valF.get(obj));
			} catch (NoSuchFieldException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//filling types.
			types.add((T) columns.get(i).getType());
			if(i==columns.size()) {
				sql_sb.append(" ) Values ( ");
				for(int k =0; k<columns.size(); k++) {
					sql_sb.append(" ? ");
					if (k==columns.size()) {
						sql_sb.append(" ) RETURNING "+tableName+"."+theClass.getPrimaryKey().getColumnName());
					} else {
						sql_sb.append(" , ");
					}
				}
			} else {
				sql_sb.append(" , ");
			}
		}
		
		System.out.println(values);
		System.out.println(types.toString());
		
//		try (Connection conn = d.getConnection()) {
//		// here, inserting an obj into a row implementation. Returns the PK identifier
//		// value for the inserted obj for the ORM
//			PreparedStatement st = conn.prepareStatement(sql_sb.toString());
//			for(int i =1; i<=values.size(); i++) {
//				
//			}
			
			
//			st.setDouble(1, 0);
//			st.setInt(2, userID);
//			st.setBoolean(3, false);
//			ResultSet rs;
//			if (!(rs = st1.executeQuery()).equals(null)) {
//				rs.next();
//				accountID=rs.getInt(1);
//			
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
		 
		
		
		
		
		
		
		
		
//		int accountID=0;
//		Connection conn = ConnectionUtility.getConnection();
//		//First create a new row in accounts table, then take the new id to create a row in the junction table
//		String sql1 = "INSERT INTO accounts  (balance, users_a_id, active) VALUES (? ,? ,?) RETURNING accounts.id";
//		try {
//			PreparedStatement st1 = conn.prepareStatement(sql1);
//			st1.setDouble(1, 0);
//			st1.setInt(2, userID);
//			st1.setBoolean(3, false);
//			ResultSet rs;
//			if (!(rs = st1.executeQuery()).equals(null)) {
//				rs.next();
//				accountID=rs.getInt(1);
//				//Now creating a new row for the junction table
//				String sql2 = "INSERT INTO users_accounts_j  (users_j_id, accounts_j_id) VALUES (? ,? )";
//				PreparedStatement st2 = conn.prepareStatement(sql2);
//				st2.setInt(1, userID);
//				st2.setInt(2, accountID);
//				st2.executeUpdate();
//				return accountID;
//			}
//			
//			
//		} catch (SQLException e) {
//			System.out.println("Unable to create account! SQL - exception!");
//			e.printStackTrace();
//		} return accountID;
		
		
		
		
//		if(!columns.isEmpty()) {
//			for()
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
