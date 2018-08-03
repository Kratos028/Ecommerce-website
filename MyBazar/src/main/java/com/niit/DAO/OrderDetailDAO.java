package com.niit.DAO;

import com.niit.model.OrderDetail;

public interface OrderDetailDAO {
	
	public boolean insertOrder(OrderDetail order);
	public boolean updateOrder(String username);
	public boolean deleteOrder(OrderDetail order);
	
}
