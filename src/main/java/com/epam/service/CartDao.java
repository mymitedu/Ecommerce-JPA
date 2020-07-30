package com.epam.service;

import java.util.Map;
import com.epam.model.Product;
/**
 * CartDao.java - The below code contain Cart functions.
 * @author  Krishna Kumar Singh
 * @role Junior Software Engineer
 * @contact krishna_singh1@epam.com
 */
public interface CartDao {
	boolean isCartHasValue();
	void addProductToCartByProductId(int productId, int quantity);
	void removeProductByProductId(int productId);
	void emptyCart();
	Map <Product,Integer> getAllCartProducts();
}
