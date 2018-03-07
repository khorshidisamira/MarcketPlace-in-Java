// Honor Pledge:
//
// I pledge that I have neither given nor received any help on this assignment.
//
// Samira Khorshidi
public class AuthorizationException extends RuntimeException {
	public AuthorizationException(String methodName) {
		super("Invalid Authorization - Access Denined to " + methodName + "() 		function!");
	}
}
