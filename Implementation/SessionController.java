// Honor Pledge:
//
// I pledge that I have neither given nor received any help on this assignment.
//
// Samira Khorshidi 
// Ryan: Why would a Controller need to be serialized...perhaps this name isn't correct.
//Fixed: I create a SessionModel and that one is serialized because we want to serialize session object

public class SessionController {
	// Ryan: Please provide useful comments in each file.
	//Fixed: I added comments
	private SessionModel model;
	
	public SessionController(String type) {
		this.model = new SessionModel(type);
	}
	
	public String getRoleType(){
		return model.getRoleType();
	}
}