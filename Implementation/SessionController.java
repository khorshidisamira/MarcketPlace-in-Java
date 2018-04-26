// Honor Pledge:
//
// I pledge that I have neither given nor received any help on this assignment.
//
// Samira Khorshidi 
import java.io.Serializable;
public class SessionController implements Serializable{
	// Ryan: Please provide useful comments in each file.
	//Fixed: I added comments
	private SessionModel model;
	
	
	public SessionController(String username, String password, String type) {
		this.model = new SessionModel(username, password, type);
	}
	
	public String getRoleType(){
		return model.getRoleType();
	}
	
	public String getUsername(){
		return model.getUsername();
	}
}