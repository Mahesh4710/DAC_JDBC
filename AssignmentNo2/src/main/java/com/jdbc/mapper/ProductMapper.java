package com.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.pojo.Product;

public class ProductMapper {
	public static Product mapRow(ResultSet rs) throws SQLException {
		Product product=new Product();
		product.setPid(rs.getInt(1));
		product.setpName(rs.getNString(2));
		product.setPrice(rs.getInt(3));
		return product;
	}

	
}
