package com.niit.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.niit.model.Category;
import com.niit.model.User;


@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().save(category);
			return true;
			
		}
		catch(Exception e) {
			return false;
		}
		
	
	}

	@Override
	public boolean updateCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
			
		}
		catch(Exception e) {
			return false;
		}
			
	}

	@Override
	public boolean deleteCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
			
		}
		catch(Exception e) {
			return false;
		}
		
	}

	@Override
	public Category getCategory(int id) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Category cat = (Category)session.get(Category.class,id);
			
			return cat;
			
		}
		catch(Exception e)
		{
			return null;
		}
	}

	@Override
	public List<Category> listCategory() {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from Category");
			List<Category> listcategory = query.list();
			return listcategory;
		}
		catch(Exception e)
		{
			return null;
		}
	}

}
