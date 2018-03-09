// Honor Pledge:
//
// I pledge that I have neither given nor received any help on this assignment.
//
// Samira Khorshidi
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// Ryan: Why is the handler Serializable?
public class AuthorizationInvocationHandler implements InvocationHandler, Serializable {
	private Object objectImpl;
	 
	public AuthorizationInvocationHandler(Object impl) {
	   this.objectImpl = impl;
	}
	 
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (method.isAnnotationPresent(RequiresRole.class)) {
			RequiresRole test = method.getAnnotation(RequiresRole.class);
			SessionController session = (SessionController) args[0];
			//String session = (String) args[0];
			
			if (session.getRoleType().equals(test.value())) {//if (session.equals(test.value())) {//
				return method.invoke(objectImpl, args);
			} else {
				
				throw new AuthorizationException(method.getName());
			}
		} else {
			return method.invoke(objectImpl, args);
		}   
	}
}
