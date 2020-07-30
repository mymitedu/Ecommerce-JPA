package com.epam.view;

import java.util.Iterator;
import java.util.List;
import com.epam.model.SubCategory;
import com.epam.service.SubCategoryService;

/**  
 * SubCategoryView.java - The code below is contain View of SubCategory.
 * ---------------------------------------------------------------------------------------------------------------------------------------------------
 * | Functions                                                         | Accessibility | Return Type           | Description						 |
 * ---------------------------------------------------------------------------------------------------------------------------------------------------
 * | storeSubCategoriesMenu() 										   | public        | void                  | Store SubCategories Menu.           | 
 * | storeSubCategoriesChoice()                                        | public        | void                  | Store SubCategories Choice.         |
 * | displayStoreSubCategories() 		 	                           | public        | void                  | Display Store SubCategories.        |
 * | displaySubCategoryByCategoryId() 							       | public        | void                  | Display SubCategory by Category Id. | 
 * | printSubCategoriesTableOnConsole(List<SubCategory> subCategories) | private       | void                  | print SubCategory on Console.       | 
 * ---------------------------------------------------------------------------------------------------------------------------------------------------
 * @author  Krishna Kumar Singh
 * @role Junior Software Engineer
 * @contact krishna_singh1@epam.com
 */

public class SubCategoryView {
	
	private SubCategoryView() {}

	public static void storeSubCategoriesMenu() {
		System.out.println("Press 1. To Choose Sub-Category ID whose products you want to see");
		System.out.println("2. To Display All Store Categories");
		System.out.println("3. To Display Cart");
		System.out.println("4. To Remove From Cart");
		System.out.println("5. To Buy Now");
		System.out.println("0. To Quit");
		System.out.print("Enter your choice : ");
	}

	public static void storeSubCategoriesChoice() {
		switch (Index.getUserChoice()) {
		case 1:
			System.out.print("Enter your the Sub-Category ID from above Table whose products you want to see : ");
			Index.getUserIntInput();
			ProductView.displayProductsBySubCategory();
			ProductView.storeProductsMenu();
			Index.getUserIntInput();
			ProductView.storeProductsChoice();
			break;
		case 2:
			CategoryView.displayStoreCategories();
			CategoryView.storeCategoriesMenu();
			Index.getUserIntInput();
			CategoryView.storeCategoriesChoice();
			break;
		case 3:
			Index.showCart();
			break;
		case 4:
			Index.removeProductFromCart();
			break;
		case 5:
			Index.buyNow();
			Index.removeAllProductsFromCart();
			break;
		default:
			break;
		}
	}

	public static void displayStoreSubCategories() {
		List<SubCategory> subCategories = new SubCategoryService().getAllSubCategories();
		printSubCategoriesTableOnConsole(subCategories);
	}

	public static void displaySubCategoryByCategoryId() {
		System.out.print("Enter your the Category ID from above Table whose sub-categories you want to see : ");
		int categoryId = Index.getUserIntInput();
		List<SubCategory> subCategories = new SubCategoryService().getSubCategoryByCategoryId(categoryId);
		printSubCategoriesTableOnConsole(subCategories);
	}

	private static void printSubCategoriesTableOnConsole(List<SubCategory> subCategories) {
		String hyphenGroup = "+------------------+-------------------------------------+%n";
		System.out.println("\n\n\n");
		String leftAlignFormat = "| %-16d | %-35s |%n";
		System.out.format(hyphenGroup);
		System.out.format("| SubCategory ID   | SubCategory Name                    |%n");
		System.out.format(hyphenGroup);
		for (SubCategory subCateg : subCategories) {
			System.out.format(leftAlignFormat, subCateg.getSubCategoryId(), subCateg.getName());
		}
		System.out.format(hyphenGroup);
	}
}
