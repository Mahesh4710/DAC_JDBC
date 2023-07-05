package com.jdbcdemo.dao.productdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.dao.ProductDao;
import com.jdbcdemo.connection.DbConnection;
import com.jdbcdemo.mapper.ProductMapper;
import com.jdbcdemo.pojo.Product;

public class ProductDaoImpl implements ProductDao {

	@Override
	public List<Product> getAllProducts() {
		
		List <Product> lst=new ArrayList<>();
		
		try(Connection con=DbConnection.getDatabaseConnection()) {
			PreparedStatement pst=con.prepareStatement("Select * from product");
			
			ResultSet rs=pst.executeQuery();
			
			if(rs.isBeforeFirst()) {
				while(rs.next()) {
				Product product =ProductMapper.mapRow(rs);
				
				lst.add(product);
				}
				return lst;
			}
			
			else {
				return lst;
			}
			
		} catch (NullPointerException e) {
			System.out.println("Connection to db failed");
			return lst;
		}catch (SQLException exc) {
			exc.printStackTrace();
			lst.clear();
			return lst;
		}
	}

	@Override
	public Product searchProduct(int id) {
		try(Connection con=DbConnection.getDatabaseConnection()) {
			
			PreparedStatement pst=con.prepareStatement("select * from"
					+"product where id=?");
			pst.setInt(1, 1);
			ResultSet rs=pst.executeQuery();
			if(rs.isBeforeFirst()) {
				rs.next();
				Product product =ProductMapper.mapRow(rs);
				return product;
				}
				
			
			
			
			
		} catch (NullPointerException e) {
			System.out.println("Connection to Db failed !");
			return null;
		}catch (SQLException exc) {
			exc.printStackTrace();
			return null;

		}
		//return null;
		return null;
	}

	@Override
	public boolean addNewProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
