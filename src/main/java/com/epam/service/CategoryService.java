package com.epam.service;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.dao.DbConnect;
import com.epam.dao.DbConnectDao;
import com.epam.model.Category;

/**  
 * CategoryService.java - The code below is contain logic of Category.
 * -----------------------------------------------------------------------------------------------------------------------------------------------
 * | Functions                                                   | Accessibility | Return Type           | Description							 |
 * -----------------------------------------------------------------------------------------------------------------------------------------------
 * | getAllCategories() 										 | public        | List<Category>        | Get all Categories.                   | 
 * | initializeStoreCategories()                                 | public        | void                  | Initialize Store Categories.          |
 * -----------------------------------------------------------------------------------------------------------------------------------------------
 * @author  Krishna Kumar Singh
 * @role Junior Software Engineer
 * @contact krishna_singh1@epam.com
 */

public class CategoryService implements CategoryDao {
	private static Logger logger = LogManager.getLogger(CategoryService.class);
	DbConnectDao dbConnect = new DbConnect();
	private static List<Category> categories = new ArrayList<>();
	
    public CategoryService () {
    	if(categories.isEmpty())
    		this.initializeStoreCategories();
    }
    
    public List<Category> getAllCategories() {
    	logger.info("getCategories() started");
        return categories;
    }
    
    public synchronized void initializeStoreCategories() {  
    	logger.info("initializeProductsCategories() started");
    	categories = dbConnect.getCategories();
    }
}