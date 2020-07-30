package com.epam.servicetest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.epam.service.CategoryDao;
import com.epam.service.CategoryService;

public class CategoryServiceTest {
	CategoryDao category = new CategoryService();
	
	/*
	 * 1. getAllCategories() - - should return some value
	 * 
	 */
	
	@Test
	void test1() {
		assertNotNull(category.getAllCategories());
	}	
}
