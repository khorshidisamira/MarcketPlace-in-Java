// Honor Pledge:
//
// I pledge that I have neither given nor received any help on this assignment.
//
// Samira Khorshidi
/**
 * Factory users don't care which concrete factory they use since they work with
 * factories and products through abstract interfaces.
 */
 
import java.io.Serializable;

public class Application implements Serializable {
    private UserInterface user;
    private ProductInterface product;

    public Application(GUIFactory factory) {
        user = factory.createUser();
        product = factory.createProduct();
    }

    public String login() {
		//user.setInfo(username, password);
        return user.login();
		
	}
	
	public String showProductList() {
		
		return product.showProductList();
	}
	
	public String addProduct( String name, float price, String description, int quantity){
		
		return product.addProduct(name, price, description, quantity);
	}
	
	public String addToCart(String username,  int productIndex, int quantity) {
		return product.addToCart(username, productIndex, quantity);
	}
	
}