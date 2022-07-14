package com.revature.helpers;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.revature.configs.DbConfig;
import com.revature.util.ColumnField;
import com.revature.util.FkField;
import com.revature.util.MetaClassModel;
import com.revature.util.PkField;

public class Session<T> {

	DbConfig d = new DbConfig();

	public int insertToDb(Object obj) {

		// Extracting the metaClassModel from the object.
		Class<?> clays;
		clays = obj.getClass();
		MetaClassModel<Class<?>> theClass = MetaClassModel.of(obj.getClass());

		// returned value
		int returnedId = -1;

		// Getting the values/types from the given obj
		List<T> values = new ArrayList<>();
		List<T> types = new ArrayList<>();
		

		// Getting to know the obj
		String tableName = theClass.getTableNameFromMetaClass();
		List<ColumnField> columns = theClass.getColumns();
		List<FkField> fkColums = theClass.getForeignKeys();
		// Building the sql string before loading values;
		StringBuilder sql_sb = new StringBuilder();
		sql_sb.append("INSERT INTO " + tableName + " ( ");
		for (int i = 0; i < columns.size(); i++) {
			sql_sb.append(columns.get(i).getColumnName() + " ");
			try {
				Field valF = clays.getDeclaredField(columns.get(i).getName());
				// filling values.
				valF.setAccessible(true);
				values.add((T) valF.get(obj));
			} catch (NoSuchFieldException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// filling types.
			types.add((T) columns.get(i).getType());
			if (i+1 == columns.size() +fkColums.size()) {
				sql_sb.append(" ) Values ( ");
				
				for (int k = 0; k < columns.size()+fkColums.size(); k++) {
					sql_sb.append(" ? ");
					if (k+1 == columns.size()+fkColums.size()) {
						sql_sb.append(" ) RETURNING " + tableName + "." + theClass.getPrimaryKey().getColumnName());
					} else {
						sql_sb.append(" , ");
					}
				}
				
			} else {
					 sql_sb.append(" , ");
					 if(i+1==columns.size()) {
						 for(int x=0; x<fkColums.size(); x++) {
							 sql_sb.append(fkColums.get(x).getColumnName() + " ");
							 
							 try {
									Field valF = clays.getDeclaredField(fkColums.get(x).getName());
									// filling values.
									valF.setAccessible(true);
									Class<?> clazzTemp = Class.forName(valF.get(obj).getClass().toString().substring(6));
									 MetaClassModel<T> mcm ;
									 mcm = (MetaClassModel<T>) MetaClassModel.of(clazzTemp );
       								//
									 values.add((T) "1");
								} catch (NoSuchFieldException | SecurityException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (IllegalArgumentException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (IllegalAccessException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (ClassNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							// filling types.
							
							 types.add((T) "PK");
							 
						 }
								sql_sb.append(" ) Values ( ");
								
								for (int k = 0; k < columns.size()+fkColums.size(); k++) {
									sql_sb.append(" ? ");
									if (k+1 == columns.size()+fkColums.size()) {
										sql_sb.append(" ) RETURNING " + tableName + "." + theClass.getPrimaryKey().getColumnName());
									} else {
										sql_sb.append(" , ");
									}
								}
						 }
			}
		}
		try (Connection conn = d.getConnection()) {
			// here, inserting an obj into a row implementation. Returns the PK identifier
			PreparedStatement st = conn.prepareStatement(sql_sb.toString());
			for (int i = 0; i < types.size(); i++) {

				if (types.get(i).toString().equalsIgnoreCase("int")) {
					st.setInt(i+1, (int) values.get(i));
					
				} else if (types.get(i).toString().equalsIgnoreCase("class java.lang.String")) {
					st.setString(i+1 , values.get(i).toString());
				} 
				
				else if(types.get(i).toString().equalsIgnoreCase("PK")) {
					st.setInt(i+1, 1); //for the demo to proceed.
				}
				else {
					st.setInt(i+1 , (Integer) values.get(i));
				}
			}
			ResultSet rs;
			if (!(rs = st.executeQuery()).equals(null)) {
				rs.next();
				returnedId = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
		return returnedId;

	}

	public void deleteFromDb(Object obj) {
		// Extracting the metaClassModel from the object.
				Class<?> clays;
				clays = obj.getClass();
				MetaClassModel<Class<?>> theClass = MetaClassModel.of(obj.getClass());
				// Getting to know the obj
				String tableName = theClass.getTableNameFromMetaClass();
				PkField objPkField = theClass.getPrimaryKey();
				
				int PKValue = 0 ;
				
				//This is the object PK Field Name
				String PKFieldName = objPkField.getName();
				
				try {
					Field valF = clays.getDeclaredField(objPkField.getName());
					valF.setAccessible(true);
					//Getting the object PK value
					PKValue = (int) valF.get(obj);
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
				
				// Building the sql string before loading PK for deletion;
				StringBuilder sql_sb = new StringBuilder();
				sql_sb.append("DELETE FROM " + tableName + " WHERE "+ PKFieldName +" = "+PKValue);
				try (Connection conn = d.getConnection()) {
					
					PreparedStatement st = conn.prepareStatement(sql_sb.toString());
					st.executeUpdate();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	public void updateInDb(Object obj) {
		//Update
	}

	public void readFromDb(Object obj) {
		// Extracting the metaClassModel from the object.
		Class<?> clays;
		clays = obj.getClass();
		MetaClassModel<Class<?>> theClass = MetaClassModel.of(obj.getClass());
		// Getting to know the obj
		String tableName = theClass.getTableNameFromMetaClass();
		PkField objPkField = theClass.getPrimaryKey();
		
		int PKValue = 0 ;
		
		//This is the object PK Field Name
		String PKFieldName = objPkField.getName();
		
		try {
			Field valF = clays.getDeclaredField(objPkField.getName());
			valF.setAccessible(true);
			//Getting the object PK value
			PKValue = (int) valF.get(obj);
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
		
		// Building the sql string before loading PK for deletion;
		StringBuilder sql_sb = new StringBuilder();
		sql_sb.append("SELECT * FROM " + tableName + " WHERE "+ PKFieldName +" = "+PKValue+";");
		try (Connection conn = d.getConnection()) {
			
			PreparedStatement st = conn.prepareStatement(sql_sb.toString());
			
			ResultSet rs = st.executeQuery();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			
			int columnsNumber = rsmd.getColumnCount();
			while (rs.next()) {
				 System.out.println("\n====== "+rsmd.getTableName(1)+" with ID of "+rs.getObject(1).toString()+" ======");
			    for (int i = 1; i <= columnsNumber; i++) {
			        String columnValue = rs.getObject(i).toString();
			        System.out.print( rsmd.getColumnName(i)+ " => " +columnValue+"\n" );
			    }
			    System.out.println("===========================================");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
