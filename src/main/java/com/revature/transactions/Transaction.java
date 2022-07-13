package com.revature.transactions;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
//import java.sql.Savepoint;
//import java.util.HashMap;

public class Transaction {

	
	private static Connection conn;
//	private static HashMap<Integer, Savepoint> Savepoints;
	

	public Transaction(){}

	public void beginTransaction()throws SQLException{
		 conn.beginRequest();}
	
	public void setCommit()throws SQLException{
		 conn.commit();}
	
	public void setSavepoint()throws SQLException{
		 conn.setSavepoint();}
	
	public void releaseSavepoint(Savepoint s)throws SQLException{
		 conn.releaseSavepoint(s);}
	
	public void rollBack()throws SQLException{
		 conn.rollback();}
	
	public void rollBackToSavepoint()throws SQLException{
		 conn.rollback();}
	
//	public HashMap<Integer, Savepoint> getAllSavepoints()throws SQLException{
//		return Savepoints;
//		 }
//	
//	public void registerSavepoint() throws SQLException{
//		
//	}
	
	
	
}
