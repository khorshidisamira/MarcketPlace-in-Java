// Honor Pledge:
//
// I pledge that I have neither given nor received any help on this assignment.
//
// Samira Khorshidi
import java.util.Scanner;
// Ryan: Please provide useful comments in each file.
//Fixed: I added some new comments
public class AdminView {
	// Generic method for displaying the Admin View
	//This method is simulating the view that an Admin user see after login
	public void showView(ServerInterface myMarketPlace, SessionController session) {
		System.out.println("Welcome to the Admin Page!");

		try{
			System.out.println(myMarketPlace.showAdminIsAuthenticated(session));
		} catch(Exception e){
			System.out.println("Client Exception: " + e.getMessage());
		}
		Scanner input = new Scanner(System.in);
		// myMarketPlace.loginAdmin(myUser);
		// Main menu
		int option;
		int productIndex;
		String username;
		String password;
		int userId;
		int productId;
		String name;
		double price;
		String description;
		int quantity;

		do {
			System.out.println("********************************");
			System.out.println("*  1- Create a Customer        *");
			System.out.println("*  2- Update a Customer        *");
			System.out.println("*  3- Remove a Customer        *");
			System.out.println("*           ----               *");
			System.out.println("*  4- Create an Administrator  *");
			System.out.println("*  5- Update an Administrator  *");
			System.out.println("*  6- Remove an Administrator  *");
			System.out.println("*           ----               *");
			System.out.println("*  7- Add new product          *");
			System.out.println("*  8- Update a product         *");
			System.out.println("*  9- Remove a product         *");
			System.out.println("*  10- Logout from system      *");
			System.out.println("********************************");
			System.out.print("Please choose an option:\t");
			option = input.nextInt();

			switch (option) {
			case 1:
				System.out.println("Creating new customer...");
				System.out.print("Please enter a username:\t");
				username = input.next();
				System.out.print("Please enter a password:\t");
				password = input.next();
				// myMarketPlace.createCustomer( username, password);
				break;
			case 2:
				System.out.println("Updating a customer...");
				System.out.print("Please enter a user id:\t");
				userId = input.nextInt();
				System.out.print("Please enter a new password:\t");
				password = input.next();
				// myMarketPlace.updateCustomer( userId, password);
				break;
			case 3:
				System.out.println("Removing a customer...");
				System.out.print("Please enter a user id:\t");
				userId = input.nextInt();
				// myMarketPlace.removeCustomer( myuUser, userId);
				break;
			case 4:
				System.out.println("Creating new administrator...");
				System.out.print("Please enter a username:\t");
				username = input.next();
				System.out.print("Please enter a password:\t");
				password = input.next();
				// myMarketPlace.createAdministrator( username, password);
				break;
			case 5:
				System.out.println("Updating an administrator...");
				System.out.print("Please enter a user id:\t");
				userId = input.nextInt();
				System.out.print("Please enter a new password:\t");
				password = input.next();
				// myMarketPlace.updateAdmin( userId, password);
				break;
			case 6:
				System.out.println("Removing an administrator...");
				System.out.print("Please enter a user id:\t");
				userId = input.nextInt();
				// myMarketPlace.removeAdministrator( myuUser, userId);
				break;
			case 7:
				System.out.println("Adding new product...");
				System.out.print("Please enter product name:\t");
				name = input.nextLine();
				input.nextLine();
				System.out.print("Please enter product price:\t");
				price = input.nextDouble();
				System.out.print("Please enter product decription:\t");
				description = input.nextLine();
				input.nextLine();
				System.out.print("Please enter product quantity:\t");
				quantity = input.nextInt();
				// myMarketPlace.addProduct( name, price, description, quantity);
				break;
			case 8:
				System.out.println("Updating a product...");
				System.out.print("Please enter product id:\t");
				productId = input.nextInt();
				System.out.print("Please enter new product name:\t");
				name = input.nextLine();
				input.nextLine();
				System.out.print("Please enter new product price:\t");
				price = input.nextDouble();
				System.out.print("Please enter new product decription:\t");
				description = input.nextLine();
				input.nextLine();
				System.out.print("Please enter new product quantity:\t");
				quantity = input.nextInt();
				// myMarketPlace.updateProduct(productId, name, price, description, quantity);
				break;
			case 9:
				System.out.println("Removing a product...");
				System.out.print("Please enter product id:\t");
				productId = input.nextInt();
				// myMarketPlace.removeProduct(productId);
				break;

			case 10:
				// myMarketPlace.logoutAdmin(myUser);
			}
		} while (option != 10/* myUser.getLoginStatus() */);
	}

}