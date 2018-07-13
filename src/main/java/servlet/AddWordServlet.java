package servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddWordServlet
 */
@WebServlet("/addWord")
public class AddWordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String ADD_WORD_JSP_NAME = "/addWord.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddWordServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(AddWordServlet.ADD_WORD_JSP_NAME).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = (String) request.getParameter("title");
		String arrayValues[] = request.getParameterValues("meaningList");

		for (int i = 0; i < arrayValues.length; i++) {
			System.out.println(arrayValues[i]);
		}

		Enumeration<String> nameList = request.getParameterNames();

		while (nameList.hasMoreElements()) {
			String e = nameList.nextElement();
			System.out.println(e);
		}

		doGet(request, response);
	}

}
