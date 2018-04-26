// Honor Pledge:
//
// I pledge that I have neither given nor received any help on this assignment.
//
// Samira Khorshidi
/**
 * Each concrete factory extends basic factory and responsible for creating
 * products of a single variety.
 */
public class CustomerFactory implements GUIFactory {
	private CustomerUser user;
	
	public CustomerFactory(String username, String password){
		this.user = new CustomerUser(username, password);
	}
	
	
    @Override
    public CustomerUser createUser() {
        return user;
    }

    @Override
    public CustomerProduct createProduct() {
        return new CustomerProduct();
    }
}