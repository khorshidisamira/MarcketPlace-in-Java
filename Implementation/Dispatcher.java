// Honor Pledge:
//
// I pledge that I have neither given nor received any help on this assignment.
//
// Samira Khorshidi
public class Dispatcher {
	// Concrete Views...
	private CustomerView customerView;
	private AdminView adminView;

	/**
	 * Dispatcher Constructor
	 */
	public Dispatcher() {
		customerView = new CustomerView();
	    adminView = new AdminView();
	}

	/**
	 * Based upon the request - dispatch the view.
	 * 
	 * @param request
	 */
	public void dispatch(ServerInterface serverObject, String request) {
		// Admin or Customer Views
		if(request.equalsIgnoreCase("CUSTOMER")) {
			customerView.showView(serverObject);
	    } else {
	    	adminView.showView(serverObject);
	    }	
	}
}