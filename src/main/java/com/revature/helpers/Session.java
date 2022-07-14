package com.revature.helpers;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.revature.configs.DbConfig;
import com.revature.util.ColumnField;
import com.revature.util.FkField;
import com.revature.util.MetaClassModel;

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
		List<FkField> foreignFieldsColumns = theClass.getForeignKeys();

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
			if (i + 1 == columns.size()) {
				sql_sb.append(" ) Values ( ");
				for (int k = 0; k < columns.size(); k++) {
					sql_sb.append(" ? ");
					if (k + 1 == columns.size()) {
						sql_sb.append(" ) RETURNING " + tableName + "." + theClass.getPrimaryKey().getColumnName());
					} else {
						sql_sb.append(" , ");
					}
				}
			} else {
				sql_sb.append(" , ");
			}
		}

		try (Connection conn = d.getConnection()) {
			// here, inserting an obj into a row implementation. Returns the PK identifier
			PreparedStatement st = conn.prepareStatement(sql_sb.toString());
			for (int i = 0; i < types.size(); i++) {
				if (types.get(i).toString().equalsIgnoreCase("int")) {
					st.setInt(i + 1, (int) values.get(i));

				} else if (types.get(i).toString().equalsIgnoreCase("class java.lang.String")) {
					st.setString(i + 1, values.get(i).toString());
				} else {
					st.setInt(i + 1, (int) values.get(i));
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

		// returned value
		int returnedId = -1;

		// Getting the values/types from the given obj
		List<T> values = new ArrayList<>();
		List<T> types = new ArrayList<>();

		// Getting to know the obj
		String tableName = theClass.getTableNameFromMetaClass();
		List<ColumnField> columns = theClass.getColumns();
		List<FkField> foreignFieldsColumns = theClass.getForeignKeys();

		// Building the sql string before loading values;
		StringBuilder sql_sb = new StringBuilder();
		sql_sb.append("DELETE FROM " + tableName + " ( ");
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
			if (i + 1 == columns.size()) {
				sql_sb.append(" ) Values ( ");
				for (int k = 0; k < columns.size(); k++) {
					sql_sb.append(" ? ");
					if (k + 1 == columns.size()) {
						sql_sb.append(" ) RETURNING " + tableName + "." + theClass.getPrimaryKey().getColumnName());
					} else {
						sql_sb.append(" , ");
					}
				}
			} else {
				sql_sb.append(" , ");
			}
		}

		try (Connection conn = d.getConnection()) {
			// here, deleting an obj from a row implementation. Returns the PK identifier
			PreparedStatement st = conn.prepareStatement(sql_sb.toString());
			for (int i = 0; i < types.size(); i++) {
				if (types.get(i).toString().equalsIgnoreCase("int")) {
					st.setInt(i + 1, (int) values.get(i));

				} else if (types.get(i).toString().equalsIgnoreCase("class java.lang.String")) {
					st.setString(i + 1, values.get(i).toString());
				} else {
					st.setInt(i + 1, (int) values.get(i));
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

	public int updateInDb(Object obj) {
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
		List<FkField> foreignFieldsColumns = theClass.getForeignKeys();

		// Building the sql string before loading values;
		StringBuilder sql_sb = new StringBuilder();
		sql_sb.append("UPDATE " + tableName + " SET ( ");
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
			if (i + 1 == columns.size()) {
				sql_sb.append(" ) Values ( ");
				for (int k = 0; k < columns.size(); k++) {
					sql_sb.append(" ? ");
					if (k + 1 == columns.size()) {
						sql_sb.append(" ) RETURNING " + tableName + "." + theClass.getPrimaryKey().getColumnName());
					} else {
						sql_sb.append(" , ");
					}
				}
			} else {
				sql_sb.append(" , ");
			}
		}

		try (Connection conn = d.getConnection()) {
			// here, Updating an existing obj in a row implementation. Returns the PK
			// identifier
			PreparedStatement st = conn.prepareStatement(sql_sb.toString());
			for (int i = 0; i < types.size(); i++) {
				if (types.get(i).toString().equalsIgnoreCase("int")) {
					st.setInt(i + 1, (int) values.get(i));

				} else if (types.get(i).toString().equalsIgnoreCase("class java.lang.String")) {
					st.setString(i + 1, values.get(i).toString());
				} else {
					st.setInt(i + 1, (int) values.get(i));
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

	public int readFromDb(Object obj) {
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
		List<FkField> foreignFieldsColumns = theClass.getForeignKeys();

		// Building the sql string before loading values;
		StringBuilder sql_sb = new StringBuilder();
		sql_sb.append("SELECT * FROM " + tableName + " WHERE ( ");
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
			if (i + 1 == columns.size()) {
				sql_sb.append(" ) Values ( ");
				for (int k = 0; k < columns.size(); k++) {
					sql_sb.append(" ? ");
					if (k + 1 == columns.size()) {
						sql_sb.append(" ) RETURNING " + tableName + "." + theClass.getPrimaryKey().getColumnName());
					} else {
						sql_sb.append(" , ");
					}
				}
			} else {
				sql_sb.append(" , ");
			}
		}

		try (Connection conn = d.getConnection()) {
			// here, Selecting an obj r implementation. Returns the PK identifier
			PreparedStatement st = conn.prepareStatement(sql_sb.toString());
			for (int i = 0; i < types.size(); i++) {
				if (types.get(i).toString().equalsIgnoreCase("int")) {
					st.setInt(i + 1, (int) values.get(i));

				} else if (types.get(i).toString().equalsIgnoreCase("class java.lang.String")) {
					st.setString(i + 1, values.get(i).toString());
				} else {
					st.setInt(i + 1, (int) values.get(i));
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
}
