package com.niit.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.OrderDetailDAO;
import com.niit.model.OrderDetail;

public class OrderTest {

	static OrderDetailDAO orderDeatilDAO;
	
	@BeforeClass
	public static void configure()
	{
		AnnotationConfigApplicationContext con = new AnnotationConfigApplicationContext();
		con.scan("com.niit");
		con.refresh();
		
		orderDeatilDAO=(OrderDetailDAO)con.getBean("OrderDAO");
	}
	@Ignore
	@Test
	public void inserttest()
	{
		OrderDetail detail = new OrderDetail();
		detail.setUsername("@1");
		detail.setTotalPurchase(123);
		detail.setOrderDate(new java.util.Date());
		detail.setModepayment("CC");
		assertTrue("Problem",orderDeatilDAO.insertOrder(detail));
	}
	@Test
	public void update()
	{
		assertTrue("Problem",orderDeatilDAO.updateOrder("@1"));
	}

}
