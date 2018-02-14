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
    public MarketPlaceClient() {
    	
    }
    
    public static void main(String args[]) {
        
        // RMI Security Manager
        System.setSecurityManager(new SecurityManager());

        try {
            String name = "rmi://localhost:1099/market";
            // Attempt to locate the MarketPlaceServer...
            ServerInterface myMarketPlace = (ServerInterface) Naming.lookup(name);
            
            //myMarketPlace.showProductList();
            System.out.println("Welcom to marketplace");
         // Create new instance of a Front Controller...
    		FrontController frontController = new FrontController(myMarketPlace);
    		
    		frontController.homePage();
      

        } catch (Exception e) {
            System.out.println("MarketPlaceClient Exception: "
                    + e.getMessage());
            e.printStackTrace();
        }

        System.exit(0);
    }
}
