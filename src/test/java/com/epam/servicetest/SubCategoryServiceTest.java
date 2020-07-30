package com.epam.servicetest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.epam.service.SubCategoryDao;
import com.epam.service.SubCategoryService;

public class SubCategoryServiceTest {
	SubCategoryDao subCategory = new SubCategoryService();
	
	/*
	 * 1. getAllSubCategories() - should return some value
	 * 2. getSubCategoryByCategoryId(int productId) - Should return SubCategory
	 * 
	 */
	@Test
	void test1() {
		assertNotNull(subCategory.getAllSubCategories());
	}	
	
	@Test
	void test2() {
		assertNotNull(subCategory.getSubCategoryByCategoryId(1));
	}
}
