package com.niit.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Cart;

@Repository("cartDAO")
@Transactional
public class CartDAOImpl implements CartDAO {
	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean addCart(Cart cart) {
		try
		{
			sessionfactory.getCurrentSession().save(cart);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	@Override
	public boolean updateCart(Cart cart) {
		try
		{
			sessionfactory.getCurrentSession().update(cart);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean deleteCart(Cart cart) {
		try
		{
			sessionfactory.getCurrentSession().delete(cart);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public Cart getItemByCart(int cartItemId) {
		Session session = sessionfactory.openSession();
		Cart cart = (Cart)session.get(Cart.class, cartItemId);
		return cart;
	}

	@Override
	public List<Cart> showCartItem(String email) {
		Session session = sessionfactory.openSession();
		Query quey = session.createQuery("from Cart where username=:myemail and status='NA'");
		quey.setParameter("myemail",email);
		List<Cart> listcart = (List<Cart>)quey.list();
		return listcart;
	}

}
