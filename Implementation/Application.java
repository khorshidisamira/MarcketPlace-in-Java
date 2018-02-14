// Honor Pledge:
//
// I pledge that I have neither given nor received any help on this assignment.
//
// Samira Khorshidi
/**
 * Factory users don't care which concrete factory they use since they work with
 * factories and products through abstract interfaces.
 */
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
}