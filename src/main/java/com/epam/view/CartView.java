package com.epam.view;

import java.util.Map;
import com.epam.exception.ProductDoesNotExistException;
import com.epam.model.Product;
import com.epam.service.CartDao;
import com.epam.service.CartService;

/**  
 * CartView.java - The code below is contain View of Cart.
 * 
 * -----------------------------------------------------------------------------------------------------------------------------------------------
 * | Functions                                                   | Accessibility | Return Type           | Description							 |
 * -----------------------------------------------------------------------------------------------------------------------------------------------
 * | printCartItems() 										     | public        | void                  | Print Cart Items.                     | 
 * -----------------------------------------------------------------------------------------------------------------------------------------------
 * @author  Krishna Kumar Singh
 * @role Junior Software Engineer
 * @contact krishna_singh1@epam.com
 */ 
 
public class CartView {
	CartDao cart = new CartService();
	
	public void printCartItems() {
		String hyphenGroup = "+--------------+-------------------------------------+-----------------+------------------+%n";
		int totalQuantity =0;
		int totalPrice =0;
		try {
			if (cart.isCartHasValue()) {
				System.out.println("\n\n\n");
				String leftAlignFormat = "| %-12d | %-35s | %-15s | %-16d |%n";
				System.out.format(hyphenGroup);
				System.out.format("| Product ID   | Product Name                        | Product Price   | Product Quantity |%n");
				System.out.format(hyphenGroup);
				for(Map.Entry<Product,Integer> item: cart.getAllCartProducts().entrySet()) {
					System.out.format(leftAlignFormat, item.getKey().getProductId(), item.getKey().getName(),
							item.getKey().getPrice(), item.getValue());
					System.out.format(hyphenGroup);
					totalPrice += item.getKey().getPrice()*item.getValue();
					totalQuantity += item.getValue();
				}
				leftAlignFormat = "| %-12s | %-35d | %-15s | %-16d |%n";
				System.out.format(leftAlignFormat, "Total Price", totalPrice, "Total Quantity", totalQuantity);
				System.out.format(hyphenGroup);
			} else {
				throw new ProductDoesNotExistException("You have not selected any product\n");
			}
		} catch (Exception execption) {
			System.err.println(execption.getMessage());
		}
	}
}
