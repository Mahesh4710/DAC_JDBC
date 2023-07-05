package com.appmain;



import java.util.List;

import com.operations.ImplDao;
import com.productdao.ProductDao;


public class AppMain {

	public static void main(String[] args) {

		ProductDao daoImpl = new ImplDao();
		
//		List<Product> lst = daoImpl.getAllProducts();
//		
//		if(lst.size() > 0) {
//			System.out.println("All products are : ");
//			lst.forEach(System.out::println);
//		}
//		else {
//			System.out.println("no products found");
//		}
		
//		Product product = daoImpl.searchProduct(2);
//		if(product != null)
//			System.out.println(product);
//		else
//			System.out.println("no such product found");
		
//		Product pr = new Product();
//		pr.setPname("fan");
//		pr.setPrice(1200);
//		
//		if(daoImpl.addNewProduct(pr))
//			System.out.println("product saved successfully");
//		else
//			System.out.println("product insertion failed");
		
//		Product pr = new Product();
//		pr.setPid(5);
//		pr.setPname("orient");
//		pr.setPrice(1500);
//		
//		if(daoImpl.updateProduct(pr))
//			System.out.println("product updated");
//		else
//			System.out.println("product updation failed or no"
//					+ " such product found");
		
		if(daoImpl.deleteProduct(5))
			System.out.println("product deleted successfully");
		else
			System.out.println("product deletion failed or no such"
					+ " product found");
	}
}












