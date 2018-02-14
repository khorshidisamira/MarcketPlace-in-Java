// Honor Pledge:
//
// I pledge that I have neither given nor received any help on this assignment.
//
// Samira Khorshidi
/**
 * Abstract factory knows about all (abstract) product types.
 */
public interface GUIFactory {
    public abstract UserInterface createUser();
    public abstract ProductInterface createProduct();
}