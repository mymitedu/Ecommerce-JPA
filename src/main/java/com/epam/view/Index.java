package com.epam.view;

import java.util.Scanner;
import com.epam.service.CartDao;
import com.epam.service.CartService;
import com.epam.service.CheckoutDao;
import com.epam.service.CheckoutService;

/**  
 * Index.java - The code below is manage view of whole Application
 * -----------------------------------------------------------------------------------------------------------------------------------------------
 * | Functions                                                   | Accessibility | Return Type           | Description							 |
 * -----------------------------------------------------------------------------------------------------------------------------------------------
 * | welcomeText() 										         | private       | void                  | Welcome text.                         | 
 * | defaultMenu()                                               | private       | void                  | Default Menu.                         |
 * | defaultMenuChoice() 		 	                             | public        | void                  | Default Menu Choice.                  |
 * | getUserIntegerInput() 					                     | public        | int                   | Get User int Input.                   |
 * | getUserStringInput() 										 | private       | String                | Get User String Input.                |
 * | addProductToCart() 										 | public        | void                  | Add products to Cart.                 |
 * | showCart() 									             | public        | void                  | Show Cart Products.                   |
 * | removeProductFromCart() 								     | public        | void                  | Remove Cart Products.                 |
 * | buyNow() 									                 | public        | void                  | Buy Cart Products.                    |
 * | removeAllProductsFromCart() 								 | public        | void                  | Remove all products from cart.        |
 * | getUserChoice() 									         | public        | int                   | Get User Choice.                      |
 * -----------------------------------------------------------------------------------------------------------------------------------------------
 * @author  Krishna Kumar Singh
 * @role Junior Software Engineer
 * @contact krishna_singh1@epam.com
 */ 

public class Index {
	static CartDao cart=new CartService();
	static CartView cartView = new CartView();
	static CheckoutDao checkout = new CheckoutService();
	private static int userChoice = 0;
	private static final String USER_CHOICE_TO_QUIT = "0. To Quit";
	private static final String USER_CHOICE_ENTER_YOUR_CHOICE = "Enter your choice : ";
	private static Scanner userInput;

	public Index() {
		defaultMenuChoice();
	}
	
	private void welcomeText() {
		String hyphenGroup = "+-------------------------------------------------------------+\n";
		System.out.print(hyphenGroup);
		System.out.print("|                 WELCOME TO EPAM STORE                       |\n");
		System.out.print(hyphenGroup);
		System.out.print("| WE'RE SO HAPPY TO HAVE YOU! YOU WILL BE THE FIRST TO KNOW   |\n");
		System.out.print("| ABOUT OUR LATEST STYLES, EXCLUSIVE OFFERS, AND MUCH MORE.   |\n");
		System.out.print(hyphenGroup);
	}

	private void defaultMenu() {
		System.out.println("Press 1. To Display All Store Categories");
		System.out.println("2. To Display Store All Sub-Categories");
		System.out.println("3. To Display All Store Products");
		System.out.println("4. To Display Cart");
		if (cart.isCartHasValue()) {
			System.out.println("5. To Add to Cart");
			System.out.println("6. To Remove From Cart");
			System.out.println("7. To Buy Now");
		}
		System.out.println(USER_CHOICE_TO_QUIT);
		System.out.print(USER_CHOICE_ENTER_YOUR_CHOICE);
	}

	public void defaultMenuChoice() {
		welcomeText();
		do {
			defaultMenu();
			getUserIntInput();
			switch (userChoice) {
			case 1:
				CategoryView.displayStoreCategories();
				CategoryView.storeCategoriesMenu();
				getUserIntInput();
				CategoryView.storeCategoriesChoice();
				break;
			case 2:
				SubCategoryView.displayStoreSubCategories();
				SubCategoryView.storeSubCategoriesMenu();
				getUserIntInput();
				SubCategoryView.storeSubCategoriesChoice();
				break;
			case 3:
				ProductView.displayStoreProducts();
				ProductView.storeProductsMenu();
				getUserIntInput();
				ProductView.storeProductsChoice();
				break;
			case 4:
				showCart();
				break;
			case 5:
				addProductToCart();
				showCart();
				break;
			case 6:
				removeProductFromCart();
				break;
			case 7:
				buyNow();
				removeAllProductsFromCart();
				break;
			case 0:
				System.exit(0);
				break;
			default:
				break;
			}
		} while (userChoice != 0);
	}

	public static int getUserIntInput() {
		try {
			userInput = new Scanner(System.in);
			userChoice = Integer.parseInt(userInput.nextLine());
			System.out.println("Input choice " + userChoice + " taken");
		} catch (Exception exception) {
			System.err.println("Please enter only numeric value\n\n\n\n");
			userChoice = 9999;
		}
		return userChoice;
	}
	private static String getUserStringInput() {
		String stringInput = null;
		try {
			stringInput = userInput.nextLine();
		} catch (Exception exception) {
			System.err.println("Please enter only Letters\n\n\n\n");
		}
		return stringInput;
	}

	public static void addProductToCart() {
		try {
			String userInput;
			String[] productId=null;
			String[] productQuantity=null;
			System.out.print("Choose the product Id(Seperated by comma for example: 1,3,2) : ");
			if((userInput=getUserStringInput())!=null)
				productId = userInput.replaceAll("\\s+", "").split(",");
			System.out.print("Choose the product Quantity(Seperated by comma for example: 2,1,8) : ");
			if((userInput=getUserStringInput())!=null)
				productQuantity = userInput.replaceAll("\\s+", "").split(",");
			if(productId!=null && productQuantity!=null)
				for (int i = 0; i <= productId.length - 1; i++) {
					cart.addProductToCartByProductId(Integer.parseInt(productId[i]), Integer.parseInt(productQuantity[i]));
				}
		}catch(NullPointerException nullPointerException) {
			System.out.println("Null Returned Please Call The Function Again");
		}
		catch (Exception exception) {
			System.err.println("Please enter the values in a correct formate");
		}
	}

	public static void showCart() {
		cartView.printCartItems();
	}

	public static void removeProductFromCart() {
		System.out.print("Enter the Product ID : ");
		int productId = getUserIntInput();
		cart.removeProductByProductId(productId);
	}

	public static void buyNow() {
		checkout.checkoutCartItems();
	}

	public static void removeAllProductsFromCart() {
		cart.emptyCart();
	}
	
	public static int getUserChoice() {
		return userChoice;
	}
}
