package onlineMarket;

public class CartModel { 
	
	private int cartId;
	private String username; 
	private int[] productIds; // Holds cart's productIds
	private int[] productQuantitiy;// has same index as productIds
	private String status; //pending, checkout

	public CartModel(String newUsername) {
		username = newUsername;  
		status = "pending";
	} 
	
	public String getDetails() {

		return "get Cart Details";
	} 
	
	/**
	 * Responsible to add a particular product with its quantity to the cart
	 * @param pId
	 * @param q
	 * @return true in case of success
	 */
	public boolean addToCart(int pId, int q) {
		try {
			
		productIds[productIds.length - 1] = pId;
		productQuantitiy[productQuantitiy.length - 1] = q;
		
		return true;
		} catch(Exception e) {
			return false;
		}
		
	}
	
	/**
	 * Responsible for checkout the cart
	 * @return checkout status
	 */
	public boolean checkout() {
		status = "checkout";
		return true;
	}
}