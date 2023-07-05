package com.jdbcdemo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbcdemo.pojo.Product;
import com.mysql.cj.protocol.Resultset;

public class ProductMapper {
	public static Product mapRow(ResultSet rs)throws SQLException {
		
		Product product =new Product();
		product.setPid(rs.getInt(1));
		product.setPname(rs.getString("name"));
		product.setPrice(rs.getInt("Price"));
		return product;
	}

}
