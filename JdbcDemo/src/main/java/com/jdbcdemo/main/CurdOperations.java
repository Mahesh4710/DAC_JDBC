package com.jdbcdemo.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CurdOperations {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac?useSSL=false", "root", "4710");
			
			Statement st= con.createStatement();
			
			ResultSet rs=st.executeQuery("Select * from product");
			
			if(rs.isBeforeFirst()) {
				while(rs.next()) {
					System.out.println(rs.getInt(1) + " : "+
					rs.getString("name")+ " : "+ rs.getInt(3));
				}
			}
			else
				System.out.println("No record found !");

			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
