package com.epam.service;

import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.exception.ProductDoesNotExistException;
import com.epam.model.Product;

/**  
 * CartService.java - The code below is contain logic of Cart.
 * -----------------------------------------------------------------------------------------------------------------------------------------------
 * | Functions                                                   | Accessibility | Return Type           | Description							 |
 * -----------------------------------------------------------------------------------------------------------------------------------------------
 * | isCartHasValue() 										     | public        | boolean               | Check whether cart has value or not.  | 
 * | addProductToCartByProductId(int productId, int quantity)    | public        | void                  | Add products to cart by product Id.   |
 * | addProductToCart(Product product, int quantity) 		 	 | private       | void                  | Add products to cart.                 |
 * | removeProductByProductId(int productId) 					 | public        | void                  | Remove products to cart by product Id |
 * | printCartItems() 										     | public        | void                  | Print Cart Items.                     |
 * | emptyCart() 												 | public        | void                  | Remove all Cart Products.             |
 * | getAllCartProducts() 									     | public        | Map <Product,Integer> | Get All Cart Products.                |
 * -----------------------------------------------------------------------------------------------------------------------------------------------
 * @author  Krishna Kumar Singh
 * @role Junior Software Engineer
 * @contact krishna_singh1@epam.com
 */ 

public class CartService implements CartDao{
	private static Logger logger = LogManager.getLogger(CartService.class);
	ProductDao productService= new ProductService();
	private static final Map <Product,Integer> cartProducts = new HashMap<>();
	
	public boolean isCartHasValue() {		
		logger.info("isCartHasValue() started");
		return !cartProducts.isEmpty();
	}
	
	public void addProductToCartByProductId(int productId, int quantity) {
		logger.info("addProductToCartByProductId() started");		 
		addProductToCart(productService.getProductByProductId(productId), quantity);
	}

	private void addProductToCart(Product product, int quantity) {
		logger.info("addProductToCart() started");
		if (cartProducts.get(product)!=null) {
			cartProducts.put(product,cartProducts.get(product)+quantity);
		}
		else {
			cartProducts.put(product,quantity);
		}
	}

	public void removeProductByProductId(int productId) { 
		logger.info("removeProductByProductId() started");
		try {
			int flag =0;
			for(Map.Entry<Product,Integer> item: cartProducts.entrySet()) {
				if(item.getKey().getProductId()==productId) {
					cartProducts.remove(item);
					flag =1;
				}
			}
			if(flag == 0) {
				throw new ProductDoesNotExistException("This Product is does not exist in your cart\n\n\n\n");
			}					
		} catch (Exception exception) {
			System.err.println(exception.getMessage());
		}
	}

	public void emptyCart() {
		logger.info("emptyCart() started");
		cartProducts.clear();
	}
	
	public Map <Product,Integer> getAllCartProducts(){
		return cartProducts;
	}
}