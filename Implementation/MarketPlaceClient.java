// Honor Pledge:
//
// I pledge that I have neither given nor received any help on this assignment.
//
// Samira Khorshidi

import java.rmi.Naming;
import java.util.Scanner;

/**
 * MarketPlaceClient - Value in the 'name' variable should be the location of
 * the MarketPlaceServer.
 *
 */
public class MarketPlaceClient {
	private static ViewController viewsCtrl;
    public MarketPlaceClient() {
    	MarketPlaceClient.viewsCtrl = new ViewController();
    }
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        // RMI Security Manager
        System.setSecurityManager(new SecurityManager());

        try {
//            String name = "//tesla.cs.iupui.edu/MarketPlaceServer";
            String name = "rmi://localhost:1099/market";
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
                	viewsCtrl.adminMenu();
                } else if (option == 2) {
                	viewsCtrl.customerMenu();
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
