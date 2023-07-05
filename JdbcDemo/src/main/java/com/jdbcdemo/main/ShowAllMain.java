package com.jdbcdemo.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class ShowAllMain {
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/cdac?useSSL=false", "root", "4710");
			
			Statement st = con.createStatement();
			
			ResultSet rs= st.executeQuery("SELECT * FROM product");
			if(rs.isBeforeFirst()) {
				while(rs.next()) {
					System.out.println(rs.getInt(1) + " : "+
					rs.getString("name")+ " : "+ rs.getInt(3));
				}
			}
			else {
				System.out.println("No product found");
			}
			String insertQuery = "INSERT INTO product (name, price) VALUES ('Monitor', 1030)";
			int rowsInserted = st.executeUpdate(insertQuery);
			if (rowsInserted > 0) {
				System.out.println("New product added successfully");
			}
			
			String updateQuery = "UPDATE product SET price = 199 WHERE pid = 1";
			int rowsUpdated = st.executeUpdate(updateQuery);
			if (rowsUpdated > 0) {
				System.out.println("Product updated successfully");
			} else {
				System.out.println("Product not found or unable to update");
			}
			
			String deleteQuery = "DELETE FROM product WHERE pid = 2";
			int rowsDeleted = st.executeUpdate(deleteQuery);
			if (rowsDeleted > 0) {
				System.out.println("Product deleted successfully");
			} else {
				System.out.println("Product not found or unable to delete");
			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
