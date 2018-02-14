// Honor Pledge:
//
// I pledge that I have neither given nor received any help on this assignment.
//
// Samira Khorshidi

/**
 * Each concrete factory extends basic factory and responsible for creating
 * products of a single variety.
 */
public class AdministratorFactory implements GUIFactory {
	private AdministratorUser user;
	
	public AdministratorFactory(String username, String password){
		this.user = new AdministratorUser(username, password); 
		
	}
	
	
    @Override
    public AdministratorUser createUser() {
		
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        return user;
    }

    @Override
    public AdministratorProduct createProduct() {
        return new AdministratorProduct();
    }
}