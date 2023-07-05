package com.jdbc.dao;

import java.util.List;

import com.jdbcdemo.pojo.Product;

public interface ProductDao {
	
	List<Product> getAllProducts();  
	Product searchProduct(int id);
	
	boolean addNewProduct(Product product);
	boolean updateProduct(Product product);
	boolean deleteProduct(int id);
	
}
