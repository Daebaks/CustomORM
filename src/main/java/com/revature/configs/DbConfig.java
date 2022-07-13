package com.revature.configs;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import com.revature.helpers.AnnotatedClassesRetriever;
import com.revature.util.ColumnField;
import com.revature.util.FkField;
import com.revature.util.ManyToManyField;
import com.revature.util.MetaClassModel;

public class DbConfig {

	private Connection conn;
	private List<MetaClassModel<Class<?>>> metaClassModelList;

	public void setXmlPath(String path) {
		AnnotatedClassesRetriever.getPath(path);
	}

	private void addAnnotatedClass(Class annotatedClass) {
		if (metaClassModelList == null) {
			metaClassModelList = new LinkedList<>();
		}
		metaClassModelList.add(MetaClassModel.of(annotatedClass));
	}

	private List<MetaClassModel<Class<?>>> getMetaClassModelList() {
		for (Class<?> claz : AnnotatedClassesRetriever.getAnnotatedClassesList()) {
			addAnnotatedClass(claz);
		}
		return (metaClassModelList == null) ? Collections.emptyList() : metaClassModelList;
	}

	public void buildDb() {
		System.out.println("BUILDING THE DB...");
		for (MetaClassModel<?> claz : getMetaClassModelList()) {
			// Creating the DB tables (for each class)
			List<ColumnField> columns = claz.getColumns();
			List<FkField> foreignFieldsColumns = new ArrayList<>();
			if (!claz.getForeignKeys().isEmpty()) {
				foreignFieldsColumns = new ArrayList<>();
				foreignFieldsColumns = claz.getForeignKeys();
			}
			int counter = 1;
			try (Connection conn = this.getConnection()) {
				Statement st = conn.createStatement();
				String sql = "CREATE TABLE IF NOT EXISTS " + claz.getSimpleClassName().toString() + " ("
						+ claz.getPrimaryKey().getName().toString() + " serial PRIMARY KEY, ";
				for (ColumnField cf : columns) {
					sql += cf.getColumnName().toString() + " ";
					// extracting SQL types
					if (cf.getType().getTypeName().toString().equalsIgnoreCase("java.lang.String")) {
						sql += " varchar(200) ";
					} else if (cf.getType().getTypeName().toString().equalsIgnoreCase("int")) {
						sql += " integer ";
					} else {
						sql += " integer ";
					}
					if (counter < columns.size() + foreignFieldsColumns.size()) {
						sql += " , ";
					}
					counter++;
				}
				if (!foreignFieldsColumns.isEmpty()) {
					for (FkField fkf : foreignFieldsColumns) {
						sql += fkf.getColumnName().toString() + " ";
						// extracting SQL types
						if (fkf.getType().getTypeName().toString().equalsIgnoreCase("java.lang.String")) {
							sql += "  varchar(200) NOT NULL  REFERENCES    " + fkf.getTabeleNameRefTo() + " ("
									+ fkf.getReferencesTo() + ") ";
						} else if (fkf.getType().getTypeName().toString().equalsIgnoreCase("int")) {
							sql += "  integer NOT NULL   REFERENCES   " + fkf.getTabeleNameRefTo() + " ("
									+ fkf.getReferencesTo() + ") ";
						} else {
							sql += "  integer NOT NULL   REFERENCES   " + fkf.getTabeleNameRefTo() + " ("
									+ fkf.getReferencesTo() + ") ";
						}
						if (counter < (columns.size() + foreignFieldsColumns.size())) {
							sql += ", ";
						}
						counter++;
					}
				}
				sql += " ); ";
				st.executeUpdate(sql);
			} catch (SQLException e) {
				System.out.println("Error while building the DB");
				e.printStackTrace();
			}
		}
		addJunctionTables();
		System.out.println("DB BUILT SUCCESSFULLY");
	}

	public void addJunctionTables() {
		for (MetaClassModel<?> claz : getMetaClassModelList()) {
			List<ManyToManyField> mTomFields = new ArrayList<>();
			 
			if (!claz.getMTMfields().isEmpty()) {
				mTomFields = new ArrayList<>();
				mTomFields = claz.getMTMfields();
			try (Connection conn = this.getConnection()) {
				Statement st = conn.createStatement();
				String sql="";
				for (ManyToManyField mtm : mTomFields) {
					 sql+="CREATE TABLE IF NOT EXISTS  "+ mtm.getTableMappedFrom()+"_"+mtm.getTableMappedTo()+"_junction (  " ;
					sql+=   mtm.getFkFrom() +" int NOT NULL REFERENCES  "+ mtm.getTableMappedFrom()+" ("+mtm.getFkFrom()+") , ";
					sql+= mtm.getFkTo() +" int NOT NULL REFERENCES  "+ mtm.getTableMappedTo()+" ("+mtm.getFkTo()+") ) ; ";
				}
				st.executeUpdate(sql);
			} catch (SQLException e) {
				System.out.println("Error while building JT");
				e.printStackTrace();
			}
		}	 
	}
}

	public void setupConnection(String dbUrl, String dbUsername, String dbPassword) {
		ConnectionPooling.setUrl(dbUrl);
		ConnectionPooling.setUsername(dbUsername);
		ConnectionPooling.setPassword(dbPassword);
	}

	public void setupConnection(String dnUrl, String dbUsername, String dbPassword, String dbSchema) {
		ConnectionPooling.setUrl(dnUrl);
		ConnectionPooling.setUsername(dbUsername);
		ConnectionPooling.setPassword(dbPassword);
		ConnectionPooling.setSchema(dbSchema);
	}

	public void setSchema(String schema) {
		ConnectionPooling.setSchema(schema);
	}

	public Connection getConnection() throws SQLException {
		if (ConnectionPooling.getConn() == null) {
			throw new SQLException("Connection Failed!");
		} else {
			conn = ConnectionPooling.getConn();
		}
		return conn;
	}
}
