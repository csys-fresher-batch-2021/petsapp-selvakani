package in.selva.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import in.selva.dao.UserDao;
import in.selva.service.UserService;

/**
 * Servlet implementation class UserLoginServlet.
 */

@WebServlet("/UserLoginServlet")

public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String uemail = request.getParameter("emailId");
			String userPassCode = request.getParameter("passCode");

			boolean isValidUser = UserService.isValidUser(uemail, userPassCode);
          
			String uname = UserDao.getValidUser(uemail);
			

			if (isValidUser) {
				HttpSession session = request.getSession();
				session.setAttribute("LOGGED_IN_USER", uname);
				session.setAttribute("ROLE", "USER");
				response.sendRedirect("addCart.jsp");
			}
			else {
				response.sendRedirect("userLogin.jsp?errorMessage=Invalid Login Credentials");
			}
		} catch (Exception e) {
			response.sendRedirect("userLogin.jsp?errorMessage=Invalid Login Info");
		}
	}
}