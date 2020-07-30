package com.epam.servicetest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.epam.exception.ProductDoesNotExistException;
import com.epam.service.CartDao;
import com.epam.service.CartService;
import com.epam.service.ProductDao;
import com.epam.service.ProductService;

public class ProductServiceTest {
	ProductDao product = new ProductService();
	CartDao cartService = new CartService();
			
	/*
	 * 1. getAllProducts() - should return some value
	 * 2. getProductsBySubCategoryId(int subCategoryId) - should return product
	 * 3. getProductByProductId(int productId) - should return product
	 * 4. getProductByProductId(int productId) - For incorrect product id it should return "Product not found" Exception
	 * 
	 */
	
	@Test
	void test1() {
		assertNotNull(product.getAllProducts());
	}	
	
	@Test
	void test2() {
		assertNotNull(product.getProductsBySubCategoryId(1));
	}
	
	@Test
	void test3() {
		assertNotNull(product.getProductByProductId(1));
	}
	
	@Test
	void test4() {
		Exception exception = assertThrows(ProductDoesNotExistException.class, () -> {
			product.getProductByProductId(0);
		  });
		assertTrue(exception.getMessage().equals("Product not found"));
	}
}
