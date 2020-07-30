package com.epam.view;

import java.util.Iterator;
import java.util.List;
import com.epam.model.Product;
import com.epam.service.ProductService;

/**  
 * ProductView.java - The code below is contain View of Product.
 * -----------------------------------------------------------------------------------------------------------------------------------------------
 * | Functions                                                   | Accessibility | Return Type           | Description						     |
 * -----------------------------------------------------------------------------------------------------------------------------------------------
 * | storeProductsMenu() 										 | public        | void                  | Store Products Menu.                  | 
 * | storeProductsChoice()                                       | public        | void                  | Store Products Choice.                |
 * | displayStoreProducts() 		 	                         | public        | void                  | Display Store Products Menu.          |
 * | displayProductsBySubCategory() 							 | public        | void                  | Store Products By SubCategory Id.     | 
 * | printProductsTableOnConsole(List<Product> products)		 | private       | void                  | Print Products on Console.            | 
 * -----------------------------------------------------------------------------------------------------------------------------------------------
 * @author  Krishna Kumar Singh
 * @role Junior Software Engineer
 * @contact krishna_singh1@epam.com
 */ 

public class ProductView {
	
	private ProductView() {}
	
	public static void storeProductsMenu() {
		System.out.println("Press 1. To Display All Store Categories");
		System.out.println("2. To Display All Store Sub-Categories");
		System.out.println("3. To Display Cart");
		System.out.println("4. To Add to Cart");
		System.out.println("5. To Remove From Cart");
		System.out.println("6. To Buy Now");
		System.out.println("0. To Quit");
		System.out.print("Enter your choice : ");
	}

	public static void storeProductsChoice() {
		switch (Index.getUserChoice()) {
		case 1:
			CategoryView.displayStoreCategories();
			CategoryView.storeCategoriesMenu();
			Index.getUserIntInput();
			CategoryView.storeCategoriesChoice();
			break;
		case 2:
			SubCategoryView.displayStoreSubCategories();
			SubCategoryView.storeSubCategoriesMenu();
			Index.getUserIntInput();
			SubCategoryView.storeSubCategoriesChoice();
			break;
		case 3:
			Index.showCart();
			break;
		case 4:
			Index.addProductToCart();
			Index.showCart();
			break;
		case 5:
			Index.removeProductFromCart();
			break;
		case 6:
			Index.buyNow();
			Index.removeAllProductsFromCart();
			break;
		default:
			break;
		}
	}

	public static void displayStoreProducts() {
		List<Product> products = new ProductService().getAllProducts();
		printProductsTableOnConsole(products);
	}
	
	public static void displayProductsBySubCategory() {
		List<Product> products = new ProductService().getProductsBySubCategoryId(Index.getUserChoice());
		printProductsTableOnConsole(products);
	}
	
	private static void printProductsTableOnConsole(List<Product> products) {
		String hyphenGroup = "+--------------+-------------------------------------+-----------------+------------------+%n";
		System.out.println("\n\n\n");
		String leftAlignFormat = "| %-12d | %-35s | %-15s | %-16d |%n";
		System.out.format(hyphenGroup);
		System.out.format(
				"| Product ID   | Product Name                        | Product Price   | Product Quantity |%n");
		System.out.format(hyphenGroup);
		for (Product product : products) {
			System.out.format(leftAlignFormat, product.getProductId(), product.getName(), product.getPrice(),
					product.getStock());
		}
		System.out.format(hyphenGroup);
	}
}
