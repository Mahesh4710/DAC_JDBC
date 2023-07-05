package com.dao.dbdetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	public static Connection getDbConnection() {
		try {
			Class.forName(DbDetails.DBDRIVER);
			Connection conn=DriverManager.getConnection(DbDetails.CONSTR, DbDetails.USERNAME, DbDetails.PASSWORD);
			
			return conn;
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null; 
		}
	}

//	public static Connection getDbConnection() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
