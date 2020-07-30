package com.epam.service;

import java.util.List;
import com.epam.model.SubCategory;

/**
 * SubCategoryDao.java - The below code contain SubCategory functions.
 * @author  Krishna Kumar Singh
 * @role Junior Software Engineer
 * @contact krishna_singh1@epam.com
 */

public interface SubCategoryDao {
	List<SubCategory> getAllSubCategories(); 
	List<SubCategory> getSubCategoryByCategoryId(int productId);
	void initializeStoreSubCategories();
}
