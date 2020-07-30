package com.epam.view;

import java.util.Iterator;
import java.util.List;
import com.epam.model.Category;
import com.epam.service.CategoryService;

/**  
 * CategoryView.java - The code below is contain View of Category.
 * 
 * -----------------------------------------------------------------------------------------------------------------------------------------------
 * | Functions                                                   | Accessibility | Return Type           | Description							 |
 * -----------------------------------------------------------------------------------------------------------------------------------------------
 * | storeCategoriesMenu() 										 | public        | void                  | Store Categories Menu.                | 
 * | storeCategoriesChoice()                                     | public        | void                  | Store SubCategories Choice.           |
 * | displayStoreCategories() 		 	                         | public        | void                  | Display Store Categories Menu.        |
 * -----------------------------------------------------------------------------------------------------------------------------------------------
 * @author  Krishna Kumar Singh
 * @role Junior Software Engineer
 * @contact krishna_singh1@epam.com
 */ 

public class CategoryView {
	
	private CategoryView() {}

	public static void storeCategoriesMenu() {
		System.out.println("Press 1. To Choose Category ID whose sub-categories you want to see");
		System.out.println("2. To Display All Store Sub-Categories");
		System.out.println("3. To Add to Cart");
		System.out.println("4. To Display Cart");
		System.out.println("5. To Remove From Cart");
		System.out.println("6. To Buy Now");
		System.out.println("0. To Quit");
		System.out.print("Enter your choice : ");
	}

	public static void storeCategoriesChoice() {
		switch (Index.getUserChoice()) {
		case 1:
			SubCategoryView.displaySubCategoryByCategoryId();
			SubCategoryView.storeSubCategoriesMenu();
			Index.getUserIntInput();
			SubCategoryView.storeSubCategoriesChoice();
			break;
		case 2:
			SubCategoryView.displayStoreSubCategories();
			SubCategoryView.storeSubCategoriesMenu();
			Index.getUserIntInput();
			SubCategoryView.storeSubCategoriesChoice();
			break;
		case 3:
			Index.addProductToCart();
			Index.showCart();
			break;
		case 4:
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

	public static void displayStoreCategories() {
		String hyphenGroup = "+---------------+-------------------------------------+%n";
		List<Category> categories = new CategoryService().getAllCategories();
		final String nextLine = "\n";
		System.out.println(nextLine + nextLine + nextLine);
		String leftAlignFormat = "| %-13d | %-35s |%n";
		System.out.format(hyphenGroup);
		System.out.format("| Category ID   | Category Name                       |%n");
		System.out.format(hyphenGroup);
		for (Category category : categories) {
			System.out.format(leftAlignFormat, category.getCategoryId(), category.getName());
		}		
		System.out.format(hyphenGroup);
	}
}
