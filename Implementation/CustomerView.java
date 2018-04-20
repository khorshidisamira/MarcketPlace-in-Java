// Honor Pledge:
//
// I pledge that I have neither given nor received any help on this assignment.
//
// Samira Khorshidi
import java.util.Scanner;

public class CustomerView {
	// Generic method for displaying the Customer View
	
	public void showView(ServerInterface myMarketPlace, SessionController session) {
		System.out.println("Welcome to the Customer Page!");

		Scanner input = new Scanner(System.in);
		try{
			System.out.println(myMarketPlace.showCustomerIsAuthenticated(session));
		} catch(Exception e){
			System.out.println("Client Exception: " + e.getMessage());
		}
		// Main menu
		int option;
		int productIndex;
		int productQuantity = 0;
		int quantity;
		do {
			System.out.println("*******************************");
			System.out.println("*  1- Show product list       *");
			System.out.println("*  2- Select a product        *");
			System.out.println("*  3- Add product to cart (Purchase a product) *");
			System.out.println("*  4- Logout from system      *");
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
				try{
					System.out.println(myMarketPlace.showProductList(session));
				} catch(Exception e){
					System.out.println("Client Exception: " + e.getMessage());
				}
				
				break;
			case 2:
				System.out.print("Enter the number regarding to your product:\t");
				productIndex = input.nextInt();
				try{
					System.out.printf(myMarketPlace.selectProduct(session, productIndex));
				} catch(Exception e){
					System.out.println("Client Exception: " + e.getMessage());
				}
	
				break;
			case 3:
				try{
					do {
						System.out.println("Enter a valid product index\n");
						Scanner index = new Scanner(System.in);
						productIndex = index.nextInt();
						
						System.out.println("Enter a valid product quantity\n");
						Scanner quant = new Scanner(System.in);
						quantity = quant.nextInt();
						
						String cartStatus = myMarketPlace.addToCart(session, productIndex, quantity);
						System.out.println(cartStatus);
					} while (productIndex < 1 && (quantity < 1));
				} catch(Exception e){
					System.out.println("Client Exception: " + e.getMessage());
				}
				break;
			case 4:
				//myMarketPlace.logoutCustomer();
			}

		} while (option != 4/* myUser.getLoginStatus() */);
	}

}