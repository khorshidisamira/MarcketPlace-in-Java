package onlineMarket;

import java.rmi.Naming;
import java.util.Scanner;

/**
 * MarketPlaceClient - Value in the 'name' variable should be the location of
 * the MarketPlaceServer.
 *
 */
public class MarketPlaceClient {

    public static void adminMenu(/*ServerInterface myMarketPlace*/) {
        Scanner input = new Scanner(System.in);
        //myMarketPlace.loginAdmin(myUser); 
        //Main menu
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
                    //myMarketPlace.createCustomer( username, password);
                    break;
                case 2:
                    System.out.println("Updating a customer...");
                    System.out.print("Please enter a user id:\t");
                    userId = input.nextInt();
                    System.out.print("Please enter a new password:\t");
                    password = input.next();
                    //myMarketPlace.updateCustomer( userId, password);
                    break;
                case 3:
                    System.out.println("Removing a customer...");
                    System.out.print("Please enter a user id:\t");
                    userId = input.nextInt();
                    //myMarketPlace.removeCustomer( myuUser, userId);
                    break;
                case 4:
                    System.out.println("Creating new administrator...");
                    System.out.print("Please enter a username:\t");
                    username = input.next();
                    System.out.print("Please enter a password:\t");
                    password = input.next();
                    //myMarketPlace.createAdministrator( username, password);
                    break;
                case 5:
                    System.out.println("Updating an administrator...");
                    System.out.print("Please enter a user id:\t");
                    userId = input.nextInt();
                    System.out.print("Please enter a new password:\t");
                    password = input.next();
                    //myMarketPlace.updateAdmin( userId, password);
                    break;
                case 6:
                    System.out.println("Removing an administrator...");
                    System.out.print("Please enter a user id:\t");
                    userId = input.nextInt();
                    //myMarketPlace.removeAdministrator( myuUser, userId);
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
                    //myMarketPlace.addProduct( name,  price,  description,  quantity);
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
                    //myMarketPlace.updateProduct(productId, name,  price,  description,  quantity);
                    break;
                case 9:
                    System.out.println("Removing a product...");
                    System.out.print("Please enter product id:\t");
                    productId = input.nextInt();
                    //myMarketPlace.removeProduct(productId);
                    break;

                case 10:
                    //myMarketPlace.logoutAdmin(myUser);
            }
        } while (option!=10/*myUser.getLoginStatus()*/);
    }

    public static void customerMenu(/*ServerInterface myMarketPlace*/) {
        Scanner input = new Scanner(System.in);
        //myMarketPlace.loginCustomer(myUser); //myUser.login();
        //Main menu
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
                        
  			public synchronized void logoutCustomer(CustomerController customer) throws RemoteException {

             */
            switch (option) {
                case 1:
                    System.out.println("Showing product list...");
                    //myMarketPlace.showProductList();
                    break;
                case 2:
                    System.out.print("Enter the number regarding to your product:\t");
                    productIndex = input.nextInt() - 1;
                    //String productName = myMarketPlace.selectProduct(productIndex);
                    //System.out.printf("You have selected %s\n", productName);
                    break;
                case 3:
                    do {
                        System.out.println("Enter a valid product index\n");
                        productIndex = input.nextInt();

                    } while (productIndex > 5 || productIndex < 1);
                    //String productDetails = myMarketPlace.showProductDetails(productIndex);
                    //System.out.printf("Product Details: \n %s\n", productDetails);
                    break;
                case 4:
                    do {
                        System.out.println("Enter a valid product index\n");
                        Scanner index = new Scanner(System.in);
                        productIndex = index.nextInt();
                    } while (productIndex > 5 || productIndex < 1);
                    //myMarketPlace.addToCart(myUser, productIndex);
                    break;
                case 5:
                    System.out.println("Showing product list...");
                    //myMarketPlace.showCartDetails(myUser);
                    break;
                case 6:
                //myMarketPlace.logoutCustomer(myUser);
            }

        } while (option!=6/*myUser.getLoginStatus()*/);
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        // RMI Security Manager
        System.setSecurityManager(new SecurityManager());

        try {
//            String name = "//tesla.cs.iupui.edu/MarketPlaceServer";
            String name = "rmi://localhost:1099/onlinemarket";
            // Attempt to locate the MarketPlaceServer...
            ServerInterface myMarketPlace = (ServerInterface) Naming.lookup(name);

//			UserController myUser = myMarketPlace.createUser(); //new UserModel();
            int option;
            System.out.println("Welcom to marketplace");
            do {
                System.out.println("**********************");
                System.out.println("1- Login as admin");
                System.out.println("2- Login as customer");
                System.out.println("3- Exit Marketplace!");
                System.out.println("**********************");
                System.out.print("Please choose an option:\t");
                option = input.nextInt();
                //Login as admin
                //login as customer 
                if (option == 1) {
                    adminMenu();
                } else if (option == 2) {
                    customerMenu();
                }

            } while (option != 3);

        } catch (Exception e) {
            System.out.println("MarketPlaceClient Exception: "
                    + e.getMessage());
            e.printStackTrace();
        }

        System.exit(0);
    }
}
