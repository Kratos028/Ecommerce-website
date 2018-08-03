package com.niit.DAO;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.OrderDetail;

@Repository("OrderDAO")
@Transactional
public class OrderDetailDAOImpl implements OrderDetailDAO {

	@Autowired
	SessionFactory sessionfactory;
	
	@Override
	public boolean insertOrder(OrderDetail order) {
		try {
			sessionfactory.getCurrentSession().save(order);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	@Override
	public boolean updateOrder(String username) {
			try {
				Session session = sessionfactory.getCurrentSession();
				Query query = session.createQuery("update Cart set status='P' where username=:myusername and status='NA'");
				query.setParameter("myusername",username);
				int row = query.executeUpdate();
				if(row>0)
					return true;
				else
					return false;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return false;
			}

	}

	@Override
	public boolean deleteOrder(OrderDetail order) {
		// TODO Auto-generated method stub
		return false;
	}

}
