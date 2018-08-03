package com.niit.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Products;
import com.niit.model.Supplier;

@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO{
	@Autowired
	SessionFactory sessionFactory;

	public boolean addSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().save(supplier);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	public boolean updateSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean deleteSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public Supplier getSupplierById(int sup_id) {
		Session session =sessionFactory.getCurrentSession();
		Supplier sup = (Supplier)session.get(Supplier.class,sup_id);

		return sup;
		
	}

	public List<Supplier> supplierCategories() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Supplier");
		List<Supplier> listSupplier = query.list();
		return listSupplier;
	}

}
