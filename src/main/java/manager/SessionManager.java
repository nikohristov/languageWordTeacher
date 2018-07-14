package manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.User;

public class SessionManager {
	
	public static final String SESSION_KEY_LOGGED_USER = "loggedUser";
	
	public static Boolean doesValidSessionExist(HttpServletRequest request) {
		boolean createNewSession = false;
		HttpSession session = request.getSession(createNewSession);
		
		if (session == null) {
			return false;
		}
		
		User doesLoggedUserExist = (User) session.getAttribute(SessionManager.SESSION_KEY_LOGGED_USER); 
		
		//TODO for test purposes
		System.out.println("User in session : " + doesLoggedUserExist);
		
		return doesLoggedUserExist != null;
	}
	
	public static void addUserInSession(HttpServletRequest request, User loggedUser) {
		boolean createNewSession = false;
		HttpSession session = request.getSession(createNewSession);
		session.setAttribute(SessionManager.SESSION_KEY_LOGGED_USER, loggedUser);
	}
	
}
