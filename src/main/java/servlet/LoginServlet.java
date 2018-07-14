package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.InvalidInputException;
import manager.SessionManager;
import model.User;
import service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")  
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String JSP_NAME_LOG_IN = "/login.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(LoginServlet.JSP_NAME_LOG_IN).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String returnPage = HomeServlet.JSP_NAME_HOME;	
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		
		if (username.trim().equals("") || password.trim().equals("")) {
			System.out.println("Invalid input username: " + username + " , password : " + password);
			returnPage = LoginServlet.JSP_NAME_LOG_IN;
		} else {
			UserService userService = new UserService();
			try {
				User loggedUser = userService.logInUser(username, password);
				SessionManager.addUserInSession(request, loggedUser);
			} catch (InvalidInputException e) {
				returnPage = LoginServlet.JSP_NAME_LOG_IN;
				//TODO handle Error
			}
		}
		
		request.getRequestDispatcher(returnPage).forward(request, response);
		
		return;
	}

}
