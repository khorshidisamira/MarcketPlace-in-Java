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
		String name = "rmi://localhost:1099/market";
		ServerInterface myMarketPlace = null;
		
        try { 
            // Attempt to locate the MarketPlaceServer...
            myMarketPlace = (ServerInterface) Naming.lookup(name);
        } catch(Exception e){
			System.out.println("Client Exception: " + e.getMessage());
		}
 
		//myMarketPlace.showProductList();
		System.out.println("Welcom to marketplace");
	 // Create new instance of a Front Controller...
		FrontController frontController = new FrontController(myMarketPlace);
		
		frontController.homePage();
		
        System.exit(0);
    }
}
