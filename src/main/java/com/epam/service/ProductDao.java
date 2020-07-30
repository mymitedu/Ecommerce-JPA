package com.epam.service;

import java.util.List;
import com.epam.model.Product;

/**
 * ProductDao.java - The below code contain Product functions.
 * @author  Krishna Kumar Singh
 * @role Junior Software Engineer
 * @contact krishna_singh1@epam.com
 */

public interface ProductDao {
	List<Product> getAllProducts();  
	List<Product> getProductsBySubCategoryId(int productId);
	void initializeStoreProducts();
	Product getProductByProductId(int productId);
}
