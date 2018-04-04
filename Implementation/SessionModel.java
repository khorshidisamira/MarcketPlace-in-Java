// Honor Pledge:
//
// I pledge that I have neither given nor received any help on this assignment.
//
// Samira Khorshidi

import java.io.Serializable;
//This Model is implements Serializable since we want to serialize session object
public class SessionModel implements Serializable {

	private String username;
	private String password;
	private String userType;
	private String role; 
	
	public SessionModel(String type) {
		this.userType = type;
		this.role = type;
	}
	
	public String getRoleType(){
		return this.role;
	}
}