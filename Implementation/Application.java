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

public class Application {
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
	
	public boolean getLoginStatus(){
		return user.getLoginStatus();
	}
	
	public String showProductList() {
		System.out.println("Appolication productsssss");
		String products = product.showProductList();
		return products;
	}
	
	public String selectProduct(int productIndex){
		return product.selectProduct(productIndex);
	}
	
	public String addProduct( String name, float price, String description, int quantity){
System.out.println("Appolication");
		String addStatus = product.addProduct(name, price, description, quantity);
		return addStatus;
	}
	
	public String addToCart(String username,  int productIndex, int quantity) {
		return product.addToCart(username, productIndex, quantity);
	}
	
	public String addCustomer(String username, String password) {
		return user.addCustomer(username,password);
	}
	
	public String addAdmin(String username, String password) {
		return user.addAdmin(username,password);
	}
	
	public String removeProduct(int productId){
		return product.deactivate(productId);
	}
	
	public String updateProduct( int productIndex, String newName, float newPrice, String newDescription, int newQuantity){
		return product.updateProduct(productIndex, newName, newPrice, newDescription, newQuantity);
	}

}