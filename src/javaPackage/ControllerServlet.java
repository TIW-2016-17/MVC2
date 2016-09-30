package javaPackage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("*.html")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Hash table of RequestHandler instances, keyed by request URL
	private Map handlerHash = new HashMap();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		// Complete. Retrieve from the HashMap the instance of the class which
		// implements the logic of the requested url
		RequestHandler rh = (RequestHandler) handlerHash.get(request.getServletPath());

		// Complete. If no instance is retrived redirects to error
		// response.sendError(HttpServletResponse.SC_NOT_FOUND);
		if (rh == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);

		}
		// Complete. Call the method handleRequsest of the instance in order to
		// obtain the url
		
		else {
			String viewURL = rh.handleRequest(request, response);
		}
		

		// Complete. Dispatch the request to the url obtained

	}

}
