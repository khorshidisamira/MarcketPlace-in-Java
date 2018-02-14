// Honor Pledge:
//
// I pledge that I have neither given nor received any help on this assignment.
//
// Samira Khorshidi
import java.util.Scanner;

public class CustomerView {
	// Generic method for displaying the Customer View
	public void showView(ServerInterface myMarketPlace) {
		System.out.println("Welcome to the Customer Page!");

		Scanner input = new Scanner(System.in);
		// myMarketPlace.loginCustomer(myUser); //myUser.login();
		// Main menu
		int option;
		int productIndex;

		do {
			System.out.println("*******************************");
			System.out.println("*  1- Show product list       *");
			System.out.println("*  2- Select a product        *");
			System.out.println("*  3- Show Product Details    *");
			System.out.println("*  4- Add product to cart     *");
			System.out.println("*  5- Show cart details       *");
			System.out.println("*  6- Logout from system      *");
			System.out.println("*******************************");
			System.out.print("Please choose an option:\t");
			option = input.nextInt();

			/*
			 * 
			 * public synchronized void logoutCustomer(CustomerController customer) throws
			 * RemoteException {
			 * 
			 */
			switch (option) {
			case 1:
				System.out.println("Showing product list...");
				// myMarketPlace.showProductList();
				break;
			case 2:
				System.out.print("Enter the number regarding to your product:\t");
				productIndex = input.nextInt() - 1;
				// String productName = myMarketPlace.selectProduct(productIndex);
				// System.out.printf("You have selected %s\n", productName);
				break;
			case 3:
				do {
					System.out.println("Enter a valid product index\n");
					productIndex = input.nextInt();

				} while (productIndex > 5 || productIndex < 1);
				// String productDetails = myMarketPlace.showProductDetails(productIndex);
				// System.out.printf("Product Details: \n %s\n", productDetails);
				break;
			case 4:
				do {
					System.out.println("Enter a valid product index\n");
					Scanner index = new Scanner(System.in);
					productIndex = index.nextInt();
				} while (productIndex > 5 || productIndex < 1);
				// myMarketPlace.addToCart(myUser, productIndex);
				break;
			case 5:
				System.out.println("Showing product list...");
				// myMarketPlace.showCartDetails(myUser);
				break;
			case 6:
				// myMarketPlace.logoutCustomer(myUser);
			}

		} while (option != 6/* myUser.getLoginStatus() */);
	}

}