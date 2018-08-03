package com.niit.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Category;
import com.niit.model.Products;
@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	SessionFactory sessionFactory;

	public boolean addProduct(Products product) {
		try
		{
			sessionFactory.getCurrentSession().save(product);
			return true;
			}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean updateProduct(Products product) {
		try
		{
			sessionFactory.getCurrentSession().update(product);
			return true;
			}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean deleteProduct(Products product) {
		try
		{
			sessionFactory.getCurrentSession().delete(product);
			return true;
			}
		catch(Exception e)
		{
			return false;
		}
	}

	public Products getProductById(int product_id) {
		Session session = sessionFactory.getCurrentSession();
		Products p = session.get(Products.class, product_id);
		return p;
	}
	public List<Products> listProdcut()
	{
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from Products");
			List<Products> listProducts = query.list();
			return listProducts;
		}
		catch(Exception e)
		{
			return null;
		}
	}
}
