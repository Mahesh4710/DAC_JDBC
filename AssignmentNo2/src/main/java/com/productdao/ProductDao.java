package com.productdao;

import java.util.List;

import com.dao.pojo.Product;

public interface ProductDao {
	
	List<Product> getAllProducts();
	
	Product searchProduct(int id);
	
	boolean addNewProduct(Product product);
	boolean updateProduct(Product product);
	boolean deleteProduct(int id);
	
}
