// Honor Pledge:
//
// I pledge that I have neither given nor received any help on this assignment.
//
// Samira Khorshidi
import java.util.Scanner;

public class FrontController {
	// Dispatcher instance
	private Dispatcher dispatcher;
	private ServerInterface server;
	private Application app; 
	private String loginStatus;
	private SessionController session = null;
	

	/**
	 * Front Controller Constructor
	 */
	public FrontController(ServerInterface serverObject) {
		server = serverObject;
		dispatcher = new Dispatcher();
	}
	
	public void homePage() {
		int option; 
		String username;
		String password;
		
		Scanner input = new Scanner(System.in);
		try{
		server.concurrencyTest();// test concurrency
		//server.concurrencyTestSync();
		}catch(Exception e){
			System.out.println("Exception: " + e.getMessage());
		}
	      do {
          	
              System.out.println("**********************");
              System.out.println("1- Login as admin");
              System.out.println("2- Login as customer");
              System.out.println("3- Exit Marketplace!");
              System.out.println("**********************");
              System.out.print("Please choose an option:\t");
              option = input.nextInt();
             
             
              if (option == 1) { 
				System.out.print("Please enter your username:\t");
				username = input.next();
				System.out.print("Please enter your password:\t");
				password = input.next(); 
				
				if(isAuthenticUser(username, password, "administrator")) {//Login as admin
					dispatchRequest("ADMIN");
				}
				
              } else if (option == 2) {
				System.out.print("Please enter your username:\t");
				username = input.next();
				System.out.print("Please enter your password:\t");
				password = input.next(); 
				
            	 if(isAuthenticUser(username, password, "customer")) {//Login as admin 
					dispatchRequest("CUSTOMER");
				} 
              }

          } while (option != 3);
	}

	/**
	 * Attempt to authentic user login.
	 * 
	 * @return T/F
	 */
	private boolean isAuthenticUser(String username, String password, String userRole) {
		try{
			if(userRole.equalsIgnoreCase("administrator")){
				try{
				  session = server.processLogin(username, password, "administrator");
				  System.out.println("Session is " + session.getRoleType());
				} catch(Exception e){
					System.out.println("Client Exception: " + e.getMessage());
				}
				
				//loginStatus = server.loginAdmin(username, password);
			}else{
				try{
				  session = server.processLogin(username, password, "customer");
				} catch(Exception e){
					System.out.println("Client Exception: " + e.getMessage());
				}
				//loginStatus = server.loginCustomer(username, password); 
			}
			System.out.println("User is authenticated successfully.");	 
			return true;
		 } catch (Exception e) {
            System.out.println("MarketPlaceClient Exception: "
                    + e.getMessage());
            e.printStackTrace();
			return false;
        }
	}

	/**
	 * Responsible for dispatching the request to the Dispatcher.
	 * 
	 * @param request
	 */
	public void dispatchRequest(String request) {
		System.out.println("Page Requested: " + request);    
		dispatcher.dispatch(server, session, request); 
	}
}