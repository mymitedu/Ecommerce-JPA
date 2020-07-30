package com.epam.servicetest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.epam.service.CartDao;
import com.epam.service.CartService;
import com.epam.service.ProductDao;
import com.epam.service.ProductService;

class CartserviceTest {

	CartDao cartService = new CartService();
	ProductDao productService = new ProductService();
	
	/*
	 * 1. isCartHasValue() has no value
	 * 2. isCartHasValue() has value
	 * 
	 */
	
	@Test
	void test1() {
		assertEquals(false, cartService.isCartHasValue());
	}
	
	@Test
	void test2() {
		cartService.addProductToCartByProductId(1,1);
		assertEquals(true, cartService.isCartHasValue());
	}
}
