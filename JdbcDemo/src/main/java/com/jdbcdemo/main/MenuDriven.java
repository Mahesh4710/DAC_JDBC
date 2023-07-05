package com.jdbcdemo.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MenuDriven {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cdac?useSSL=false", "root", "4710");

            Statement st = con.createStatement();

            Scanner scanner = new Scanner(System.in);

            int choice;
            do {
                System.out.println("Code is written by Mahesh");
                System.out.println("1. Show all products");
                System.out.println("2. Add a new product");
                System.out.println("3. Update a product");
                System.out.println("4. Delete a product");
                System.out.println("5. Search for a product by ID");
                System.out.println("6. Exit");

                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        showAllProducts(st);
                        break;
                    case 2:
                        addNewProduct(st);
                        break;
                    case 3:
                        updateProduct(st);
                        break;
                    case 4:
                        deleteProduct(st);
                        break;
                    case 5:
                        searchProductById(st);
                        break;
                    case 6:
                        System.out.println("Exiting the program");
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            } while (choice != 6);

            con.close();
            scanner.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void showAllProducts(Statement st) {
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM product");
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + " : " +
                            rs.getString("name") + " : " + rs.getInt(3));
                }
            } else {
                System.out.println("No products found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addNewProduct(Statement st) {
        String insertQuery = "INSERT INTO product (name, price) VALUES ('Monitor', 1030)";
        try {
            int rowsInserted = st.executeUpdate(insertQuery);
            if (rowsInserted > 0) {
                System.out.println("New product added successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateProduct(Statement st) {
        String updateQuery = "UPDATE product SET price = 199 WHERE pid = 1";
        try {
            int rowsUpdated = st.executeUpdate(updateQuery);
            if (rowsUpdated > 0) {
                System.out.println("Product updated successfully");
            } else {
                System.out.println("Product not found or unable to update");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteProduct(Statement st) {
        String deleteQuery = "DELETE FROM product WHERE pid = 2";
        try {
            int rowsDeleted = st.executeUpdate(deleteQuery);
            if (rowsDeleted > 0) {
                System.out.println("Product deleted successfully");
            } else {
                System.out.println("Product not found or unable to delete");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void searchProductById(Statement st) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product ID: ");
        int productId = scanner.nextInt();

        String searchQuery = "SELECT * FROM product WHERE pid = " + productId;
        try {
            ResultSet rs = st.executeQuery(searchQuery);
            if (rs.next()) {
                System.out.println(rs.getInt(1) + " : " +
                        rs.getString("name") + " : " + rs.getInt(3));
            } else {
                System.out.println("Product not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}
