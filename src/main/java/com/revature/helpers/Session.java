package com.revature.helpers;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.configs.DbConfig;

public class Session {

	DbConfig d = new DbConfig();

	public int insertToDb(Object obj) {

		try (Connection conn = d.getConnection()) {
			// here, inserting an obj into a row implementation. Returns the PK identifier
			// value for the inserted obj for the ORM

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return -1;

	}

	public void deleteFromDb(Object obj) {
		
		try (Connection conn = d.getConnection()) {
			// here, deleting an obj from a row implementation.
			// return a confirmation message
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(obj + " Deleted from the DB");
	}

	public void updateInDb(Object obj) {
		
		try (Connection conn = d.getConnection()) {
			// here, updating an existing obj into a row implementation.
			// return a confirmation message
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(obj + " Updated in DB");
		// return updated record
	}

	public void readFromDb(Object obj) {
		
		try (Connection conn = d.getConnection()) {
			// here, Reading an obj row implementation.
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
