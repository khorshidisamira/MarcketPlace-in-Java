// Honor Pledge:
//
// I pledge that I have neither given nor received any help on this assignment.
//
// Samira Khorshidi 
import java.io.Serializable;

// Ryan: Why would a Controller need to be serialized...perhaps this name isn't correct.

public class SessionController implements Serializable {
	// Ryan: Please provide useful comments in each file.
	private String username;
	private String password;
	private String userType;
	private String role; 
	
	public SessionController(String type) {
		this.userType = type;
		this.role = type;
	}
	
	public String getRoleType(){
		return this.role;
	}
}