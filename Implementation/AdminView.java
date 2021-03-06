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
		float price;
		String description;
		int quantity;

		do {
			System.out.println("********************************");
			System.out.println("*  1- Create a Customer        *");
			System.out.println("*           ----               *");
			System.out.println("*  2- Create an Administrator  *");
			System.out.println("*           ----               *");
			System.out.println("*  3- Add new product          *");
			System.out.println("*  4- Update a product         *");
			System.out.println("*  5- Remove a product         *");
			System.out.println("*  6- Logout from system      *");
			System.out.println("********************************");
			System.out.print("Please choose an option:\t");
			option = input.nextInt();

			switch (option) {
			case 1:
				try{
					
					System.out.println("Creating new customer...");
					System.out.print("Please enter username:\t");
					username = input.next();
					System.out.print("Please enter password:\t");
					password = input.next(); 
					
					
					//System.out.println(username);
					//System.out.println(password);
					System.out.println("Creating new customer...");
					String addStatus = myMarketPlace.createCustomer(session, username, password);
					System.out.println(addStatus);
				}catch(Exception e){
					System.out.print(e.getMessage());
				}
				break;
		
			case 2:
				try{
					System.out.println("Creating new Administrator...");
					System.out.print("Please enter username:\t");
					username = input.next();
					System.out.print("Please enter password:\t");
					password = input.next();  
					
					String addStatus = myMarketPlace.createAdministrator(session, username, password);
					System.out.println(addStatus);
				}catch(Exception e){
					System.out.print(e.getMessage());
				}
				break;
			
			case 3:
				try{
					System.out.println("Adding new product...");
					System.out.print("Please enter product name:\t");
					 input.nextLine(); 
					name = input.nextLine();
					System.out.print("Please enter product price:\t");
					price = input.nextFloat();
					System.out.print("Please enter product decription:\t");
					 input.nextLine();
					description = input.nextLine();
					System.out.print("Please enter product quantity:\t");
					quantity = input.nextInt();
					String addStatus = myMarketPlace.addProduct(session, name, price, description, quantity);
					System.out.println(addStatus);
				}catch(Exception e){
					System.out.print(e.getMessage());
				}
				break;
			case 4:
				try{
					System.out.println("Updating a product...");
					System.out.println(myMarketPlace.showProductList(session));
					System.out.print("Enter the number regarding to your product:\t");
					productIndex = input.nextInt();
					System.out.print("Please enter your new product name:\t");
					 input.nextLine(); 
					name = input.nextLine();
					System.out.print("Please enter your new product price:\t");
					price = input.nextFloat();
					System.out.print("Please enter your new product decription:\t");
					 input.nextLine();
					description = input.nextLine();
					System.out.print("Please enter your new product quantity:\t");
					quantity = input.nextInt();
					String addStatus = myMarketPlace.updateProduct(session,productIndex, name, price, description, quantity);
					System.out.println(addStatus);
				}catch(Exception e){
					System.out.print(e.getMessage());
				}
				break;
			case 5:
				System.out.println("Removing a product...");
				try{
					System.out.println(myMarketPlace.showProductList(session));
					System.out.print("Enter the number regarding to your product:\t");
					productIndex = input.nextInt();
					System.out.println(myMarketPlace.removeProduct(session, productIndex));
				} catch(Exception e){
					System.out.println("Client Exception: " + e.getMessage());
				}
				break;

			case 6:
				// myMarketPlace.logoutAdmin(myUser);
			}
		} while (option != 6/* myUser.getLoginStatus() */);
	}

}