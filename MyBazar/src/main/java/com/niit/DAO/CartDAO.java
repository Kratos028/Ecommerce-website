package com.niit.DAO;

import java.util.List;

import com.niit.model.Cart;

public interface CartDAO {
	public boolean addCart(Cart cart);
	public boolean updateCart(Cart cart);
	public boolean deleteCart(Cart cart);
	public Cart getItemByCart(int cartItemId);
	public List<Cart> showCartItem(String email);
	

}
