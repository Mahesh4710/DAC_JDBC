package com.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.dbdetails.DbConnection;
import com.dao.pojo.Product;
import com.jdbc.mapper.ProductMapper;
import com.mysql.cj.protocol.Resultset;
import com.productdao.ProductDao;

public class ImplDao implements ProductDao{

	@Override
	public List<Product> getAllProducts() {
		List<Product> lst=new ArrayList();
		try (Connection conn=DbConnection.getDbConnection()){
			PreparedStatement pst=conn.prepareStatement("select * from product");
			
			ResultSet rs=pst.executeQuery();
			if(rs.isBeforeFirst()) {
				while(rs.next()) {
					Product product=ProductMapper.mapRow(rs);
					lst.add(product);
				}
			}
			
			return lst;
			
		} catch (NullPointerException e) {
			System.out.println("connection failed");
			return lst;
		}catch (SQLException exc) {
			exc.printStackTrace();
			lst.clear();
			return lst;
		}	
	}

	@Override
	public Product searchProduct(int pid) {
		try(Connection con = DbConnection.getDbConnection()){
			
			PreparedStatement pst = con.prepareStatement("SELECT * FROM"
					+ " product WHERE id = ?");
			
			pst.setInt(1, pid);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.isBeforeFirst()) {
				rs.next();
				Product product = ProductMapper.mapRow(rs);
				return product;
			}
			else
				return null;
		} catch (NullPointerException e) {
			System.out.println("connection to database failed");
			return null;
		} catch (SQLException exc) {
			exc.printStackTrace();
			return null;
		}
	}
	@Override
	public boolean addNewProduct(Product product) {
		try (Connection con = DbConnection.getDbConnection()){
			
			PreparedStatement pst = con.prepareStatement("INSERT INTO"
					+ " product (name,price) VALUES (?,?)");
			
			pst.setString(1, product.getpName());
			pst.setInt(2, product.getPrice());
			
			int count = pst.executeUpdate();
			
			if(count > 0)
				return true;
			else
				return false;
			
		} catch (NullPointerException e) {
			System.out.println("connection to database failed");
			return false;
		} catch (SQLException exc) {
			exc.printStackTrace();
			return false;
		}
	}


	@Override
	public boolean updateProduct(Product product) {
		try (Connection con = DbConnection.getDbConnection()){
			
			PreparedStatement pst = con.prepareStatement(
			"UPDATE product SET name = ? , price = ? WHERE id = ?");
			
			pst.setString(1, product.getpName());
			pst.setInt(2, product.getPrice());
			pst.setInt(3, product.getPid());
			
			int count = pst.executeUpdate();
			
			if(count > 0)
				return true;
			else
				return false;
		} catch (NullPointerException exc) {
			System.out.println("connection to database failed");
			return false;
		} catch (SQLException exc) {
			exc.printStackTrace();
			return false;
		}		
	}


	@Override
	public boolean deleteProduct(int pid) {
		try (Connection con = DbConnection.getDbConnection()){
			
			con.setAutoCommit(false);
			
			PreparedStatement pst = con.prepareStatement("DELETE FROM"
					+ " product WHERE pid = ?");
			
			pst.setInt(1, pid);
			
			int count = pst.executeUpdate();
			
			con.commit();
			
			if(count > 0)
				return true;
			else
				return false;
			
		} catch (NullPointerException exc) {
			System.out.println("connection to database failed");
			return false;
		} catch (SQLException exc) {
			exc.printStackTrace();
			return false;
		}	
	}

}
