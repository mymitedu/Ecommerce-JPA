package com.epam.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.epam.model.Category;
import com.epam.model.Product;
import com.epam.model.SubCategory;

/**
 * DbConnect.java - The below code contain Database Connection Code. It reads
 * all data from Database tables.
 * 
 * @author Krishna Kumar Singh
 * @role Junior Software Engineer
 * @contact krishna_singh1@epam.com
 */

public class DbConnect implements DbConnectDao {
	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	private List<Category> categoryList = new ArrayList<>();
	private List<SubCategory> subCategoryList = new ArrayList<>();
	private List<Product> productList = new ArrayList<>();
	
	public DbConnect() {
		entityManagerFactory = Persistence.createEntityManagerFactory("my-local-mysql");
		entityManager = entityManagerFactory.createEntityManager();
		if (categoryList.isEmpty() && subCategoryList.isEmpty() && productList.isEmpty()) {
			try {
				entityManager.getTransaction().begin();
				initializeTableData();
				entityManager.getTransaction().commit();
			} catch (Exception exception) {
				System.out.println(exception);
			}
		}
	}

	private void initializeTableData() {
		setCategories();
		setSubCategories();
		setProducts();
	}

	private void setCategories() {
		try {
			categoryList = entityManager.createNativeQuery("select category_id, category_name from Category", Category.class).getResultList();
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}

	private void setSubCategories() {
		try {
			subCategoryList = entityManager.createNativeQuery("select subcategory_id, category_Id, subCategory_Name from SubCategory", SubCategory.class).getResultList();
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}

	private void setProducts() {
		try {
			productList = entityManager.createNativeQuery("select product_id, category_Id, subCategory_Id, product_Name, product_Price, product_stock from Product", Product.class).getResultList();
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}

	public List<Category> getCategories() {
		return categoryList;
	}

	public List<SubCategory> getSubCategories() {
		return subCategoryList;
	}

	public List<Product> getProducts() {
		return productList;
	}
}
