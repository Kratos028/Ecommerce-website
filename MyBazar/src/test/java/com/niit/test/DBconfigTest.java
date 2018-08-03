package com.niit.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.CategoryDAO;
import com.niit.DAO.ProductDAO;
import com.niit.DAO.SupplierDAO;
import com.niit.DAO.UserDAO;
import com.niit.model.Category;
import com.niit.model.Products;
import com.niit.model.Supplier;
import com.niit.model.User;

public class DBconfigTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		/*CategoryDAO categoryDAO =(CategoryDAO) context.getBean("categoryDAO");
		
		Category category = new Category();
		category.setCategoryName("Mobile:");
		category.setCategoryDesc("Samsung");
		categoryDAO.addCategory(category);
		System.out.println("Object created nice");
		category.setCategoryName("Mobi12:");
		category.setCategoryDesc("Samsung12");
		categoryDAO.addCategory(category);
		
		UserDAO userDAO =(UserDAO) context.getBean("userDAO");
		
		User user = new User();
		user.setName("Vaibhav");
		user.setEmail("123@gmail");
		user.setPassword("12345");
		user.setPhone_no(123456);
		
		userDAO.addUser(user);
		System.out.println("Object created nice wow");
		
		
SupplierDAO supplierDAO =(SupplierDAO) context.getBean("supplierDAO");
		
		Supplier supplier = new Supplier();
		supplier.setDealer_Name("Manu:");
		supplier.setDealer_desc("Ok:");
		supplier.setDealer_address("Mayur Vihar");
		supplierDAO.addSupplier(supplier);
		System.out.println("Object created nice wow wow");
		*/
		/*ProductDAO productDAO =(ProductDAO) context.getBean("productDAO");
		Products product = new Products();
		product.setProduct_name("Samsung");
		product.setDescription("Mobile");
		product.setProduct_category("Electronics");
		product.setPrice(10000);
		product.setCategoryId(1);
		product.setStock(4);
		product.setSupplierId(1);
		productDAO.addProduct(product);
		System.out.println("nice");*/
		
	}

}
