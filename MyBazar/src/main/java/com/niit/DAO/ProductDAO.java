package com.niit.DAO;

import java.util.List;

import com.niit.model.Products;

public interface ProductDAO {
	public boolean addProduct(Products product);
	public boolean updateProduct(Products product);
	public boolean deleteProduct(Products product);
	public Products getProductById(int product_id);
	public List<Products> listProdcut();
}
