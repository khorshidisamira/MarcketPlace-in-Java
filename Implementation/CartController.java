// Ryan: Missing Honor Pledge & Digital Signature.
//Fixed:
// Honor Pledge:
//
// I pledge that I have neither given nor received any help on this assignment.
//
// Samira Khorshidi

public class CartController {

	private CartModel model; 
	
	public CartController(CartModel newModel) { 
		model = newModel; 
	}
	
	/**
	 * Responsible to add product to the shopping cart
	 * @param pId
	 * @param quantity
	 */
	public boolean addToCart(int pId, int quantity) {
		
		boolean result = model.addToCart(pId, quantity);
		return result;
	}
	
	/**
	 * Responsible for creating new shopping cart
	 * @param pId
	 * @param quantity
	 */
	public CartController createCart(String username) {
		CartModel newCartModel = new CartModel(username);
		CartController cart = new CartController(newCartModel);
		return cart;
	}
	
	/**
	 * Responsible for checkout the cart
	 * @param 
	 */
	public boolean checkoutCart() {
		
		boolean result = model.checkout();
		return result;
	}
}
