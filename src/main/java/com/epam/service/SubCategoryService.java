package com.epam.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.dao.DbConnect;
import com.epam.dao.DbConnectDao;
import com.epam.model.SubCategory;

/**  
 * SubCategoryService.java - The code below is contain logic of SubCategory.
 * -----------------------------------------------------------------------------------------------------------------------------------------------
 * | Functions                                                   | Accessibility | Return Type           | Description						     |
 * -----------------------------------------------------------------------------------------------------------------------------------------------
 * | getAllSubCategories() 									     | public        | List<SubCategory>     | Get all SubCategories.                | 
 * | getSubCategoryByCategoryId(int productId)                   | public        | List<SubCategory>     | Get SubCategories by SubCategories Id.|
 * | initializeStoreSubCategories()					             | public        | void                  | Initialize Store SubCategories.       |
 * -----------------------------------------------------------------------------------------------------------------------------------------------
 * @author  Krishna Kumar Singh
 * @role Junior Software Engineer
 * @contact krishna_singh1@epam.com
 */ 

public class SubCategoryService implements SubCategoryDao {
	private static Logger logger = LogManager.getLogger(SubCategoryService.class);
	DbConnectDao dbConnect = new DbConnect();
	private static List<SubCategory> subCategories = new ArrayList<>();

	public SubCategoryService() {
		if (subCategories.isEmpty())
			this.initializeStoreSubCategories();
	}

	public List<SubCategory> getAllSubCategories() {
		logger.info("getSubCategories() started");
		return subCategories;
	}

	public List<SubCategory> getSubCategoryByCategoryId(int productId) {
		logger.info("getSubCategoryByCategoryId() started");
		return subCategories.stream().filter(subcategory -> subcategory.getCategoryId() == productId)
				.collect(Collectors.toList());
	}

	public synchronized  void initializeStoreSubCategories() {
		logger.info("initializeStoreSubCategories() started");
		subCategories = dbConnect.getSubCategories();
	}
}