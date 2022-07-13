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

	}

	public void updateInDb(Object obj) {

	}

	public void readFromDb(Object obj) {

	}
}
