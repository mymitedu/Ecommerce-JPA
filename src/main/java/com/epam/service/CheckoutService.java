package com.epam.service;

import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.exception.ProductDoesNotExistException;
import com.epam.model.Product;

/**  
 * CheckoutService.java - The code below is contain logic of Checkout.
 * -----------------------------------------------------------------------------------------------------------------------------------------------
 * | Functions                                                   | Accessibility | Return Type           | Description							 |
 * -----------------------------------------------------------------------------------------------------------------------------------------------
 * | checkoutCartItems() 										 | public        | void                  | Checkout Cart Items                   | 
 * -----------------------------------------------------------------------------------------------------------------------------------------------
 * @author  Krishna Kumar Singh
 * @role Junior Software Engineer
 * @contact krishna_singh1@epam.com
 */ 

public class CheckoutService implements CheckoutDao {
	private static Logger logger = LogManager.getLogger(CheckoutService.class);
	ProductDao productService = new ProductService();
	CartDao cart = new CartService();

	public void checkoutCartItems() {
		logger.info("checkout() started");
		try {
			if (cart.isCartHasValue()) {
				for (Map.Entry<Product, Integer> item : cart.getAllCartProducts().entrySet()) {
					int productId = item.getKey().getProductId();
					int quantityPurchased = item.getValue();
					Product product = productService.getProductByProductId(productId);
					product.setStock(product.getStock() - quantityPurchased);
				}
				System.out.println("Order Successfully Placed\n\n\n\n");
			} else {
				throw new ProductDoesNotExistException("You have not selected any product\n\n\n\n");
			}
		} catch (ProductDoesNotExistException exception) {
			System.err.println(exception.getMessage());
		}
	}
}
