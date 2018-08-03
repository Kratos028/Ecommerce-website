package com.niit.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.CartDAO;
import com.niit.model.Cart;

public class CartDAOTestCase {

	static CartDAO cartDAO;
	@BeforeClass
	public static void executefirst()
	{
		AnnotationConfigApplicationContext con = new AnnotationConfigApplicationContext();
		con.scan("com.niit");
		con.refresh();
		
		cartDAO=(CartDAO)con.getBean("cartDAO");
	}
	@Ignore
	@Test
	public void addcart()
	{
		Cart cart = new Cart();
		cart.setProductid(229);
		cart.setProductName("vb");
		cart.setQuantity(20);
		cart.setUsername("@1");
		cart.setPrice(12);
		cart.setStatus("NA");
		
		assertTrue("Problem",cartDAO.addCart(cart));
	}

}
