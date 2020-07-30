package com.epam.dao;

import java.util.List;
import com.epam.model.Category;
import com.epam.model.Product;
import com.epam.model.SubCategory;

/**
 * DbConnectDao.java - The below code contain DbConnect functions.
 * @author  Krishna Kumar Singh
 * @role Junior Software Engineer
 * @contact krishna_singh1@epam.com
 */

public interface DbConnectDao {
	public List<Category> getCategories();
	public List<SubCategory> getSubCategories();
	public List<Product> getProducts();
}
