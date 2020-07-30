package com.epam.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.dao.DbConnect;
import com.epam.dao.DbConnectDao;
import com.epam.exception.ProductDoesNotExistException;
import com.epam.model.Product;

/**
 * ProductService.java - The code below is contain logic of Product.
 * -----------------------------------------------------------------------------------------------------------------------------------------------
 * | Functions                                                   | Accessibility | Return Type           | Description						     |
 * -----------------------------------------------------------------------------------------------------------------------------------------------
 * | getAllProducts()										     | public        | List<Product>         | Get all Products.                     | 
 * | getProductsBySubCategoryId(int productId)                   | public        | List<Product>         | Get Products by SubCategory Id.       |
 * | getProductByProductId(int productId) 					     | public        | Product               | Get products by product Id.           |
 * | initializeStoreProducts() 							         | public        | void                  | Initialize store Products.            |
 * -----------------------------------------------------------------------------------------------------------------------------------------------
 * @author  Krishna Kumar Singh
 * @role Junior Software Engineer
 * @contact krishna_singh1@epam.com
 */ 

public class ProductService implements ProductDao {
	private static Logger logger = LogManager.getLogger(ProductService.class);
	private static List<Product> products = new ArrayList<>();
	DbConnectDao dbConnect = new DbConnect();

	public ProductService() {
		this.initializeStoreProducts();			
	}

	public List<Product> getAllProducts() {
		logger.info("getProducts() started");
		return products;
	}

	public List<Product> getProductsBySubCategoryId(int productId) {
		logger.info("getProductsBySubCategoryId() started");
		return products.stream().filter(product -> product.getSubCategoryId() == productId)
				.collect(Collectors.toList());
	}

	public Product getProductByProductId(int productId) {
		logger.info("getProductByProductId() started");
		return products.stream().filter(product -> product.getProductId() == productId).findAny()
				.orElseThrow(() -> new ProductDoesNotExistException("Product not found"));
	}

	public synchronized void initializeStoreProducts() {
		logger.info("initializeStoreItems() started");
		products = dbConnect.getProducts();
	}
}