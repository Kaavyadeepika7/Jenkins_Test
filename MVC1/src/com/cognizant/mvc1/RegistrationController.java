package com.cognizant.mvc1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			User user = new User();
			user.setfName(request.getParameter("fName"));
			user.setlName(request.getParameter("lName"));
			user.setPassword(request.getParameter("password"));
			user.setAddress(request.getParameter("address"));
			user.setGender(request.getParameter("gender"));
			user.setCountry(request.getParameter("country"));
			try {
				user.setAge(Integer.parseInt(request.getParameter("age")));
			} catch (NumberFormatException e) {
				throw new RegistrationBusinessException(
						"Age should be a number");
			}
			RegistrationBO registerBo = new RegistrationBO();
			try {
				if (registerBo.registerUser(user)) {
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("Success.jsp");
					dispatcher.forward(request, response);

				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (RegistrationBusinessException e) {
			request.setAttribute("message", e.getMessage());
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("Registration.jsp");
			dispatcher.forward(request, response);
		} catch (RegistrationException e) {
			e.printStackTrace();
			request.setAttribute("errmessage", "Fatal error");
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("Error.jsp");
			dispatcher.forward(request, response);
		}
	}

}
