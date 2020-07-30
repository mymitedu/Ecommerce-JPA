package com.epam.service;

import java.util.List;
import com.epam.model.Category;

/**
 * CategoryDao.java - The below code contain Category functions.
 * @author  Krishna Kumar Singh
 * @role Junior Software Engineer
 * @contact krishna_singh1@epam.com
 */

public interface CategoryDao {
	List<Category> getAllCategories();
	void initializeStoreCategories();
}
