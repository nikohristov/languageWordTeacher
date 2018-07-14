package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manager.SessionManager;
import model.User;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public static final String JSP_NAME_HOME = "/home.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String returnPage = HomeServlet.JSP_NAME_HOME;
		
		if (!SessionManager.doesValidSessionExist(request)) {
			System.out.println("No session");
			
			returnPage = LoginServlet.JSP_NAME_LOG_IN;
		} else {
			//TODO for test purposes
			HttpSession session = request.getSession(false);
			System.out.println(((User) session.getAttribute(SessionManager.SESSION_KEY_LOGGED_USER)).getUsername());
		}
		
		request.getRequestDispatcher(returnPage).forward(request, response);
		
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
