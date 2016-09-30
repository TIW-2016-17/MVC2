/*
 * ShowRecordRequestHandler.java
 *
 * Created on 13 de diciembre de 2005, 14:55
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package javaPackage;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author telmoz
 */

/**
 * Will show the data we hold about the user, or force the user to enter their
 * name so that we can look them up
 */
public class ShowRecordRequestHandler implements RequestHandler {

	private static final String SHOW_INFO_JSP = "showInfo.jsp";
	private static final String PARAMETER_NAME = "name";
	private static final String SORRY_NOT_FOUND_JSP = "sorryNotFound.jsp";
	private static final String ENTER_NAME_JSP = "enterName.jsp";
	
	private DataStore dataStore;

	public ShowRecordRequestHandler() {
		dataStore = new DataStore();
	}

	/**
	 * @return the the URL of the view that should render the response (probably
	 *         a JSP), or null to indicate that the response has been output
	 *         already and processing is complete.
	 */
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//  3 Obtain the value of the name send in the request
		String name = request.getParameter(PARAMETER_NAME);
		if (name == null) {
			// 4 If the name is NULL we should redirect to the view
			// "entername.jsp"
			return ENTER_NAME_JSP;
		} else {

			//5 If it is'nt null:
			// - create a DataStore object
			// - call its method getInfo sending the name received as a
			// parameter

			DataModelBean dataBean = dataStore.getInfo(name);

			if (dataBean == null) {
				//  6.- If no data has been found we should redirect to "sorryNotFound.jsp"
				return SORRY_NOT_FOUND_JSP;
			} else {
				//  7.- if data found:
				// - Load the object databean obtain as an attribute "dataModelBean" of
				// the request
				// - redirect to "showInfo.jsp"

				request.setAttribute("dataModelBean", dataBean);

				return SHOW_INFO_JSP;
			}
		}

	}
}