package in.selva.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServelet
 */

@WebServlet("/LoginServlet")

public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	
	{
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		
		//Step 2: call Service
		
		boolean isValid = "AdminSK".equals(username) && "AdminSK@25".equals(password);
		
		if(isValid) 
		{
			
			HttpSession session = request.getSession();
			session.setAttribute("LOGGED_IN_USER", username);
			session.setAttribute("ROLE", "ADMIN");
			response.sendRedirect("AddBreedTypes.jsp");
			
		}
		else
		{
			response.sendRedirect("AdminLogin.jsp?errorMessage=Invalid Login Credentials");
		}
	}
=======
package in.selva.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServelet
 */

@WebServlet("/LoginServlet")

public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	
	{
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		
		//Step 2: call Service
		
		boolean isValid = "Admin".equals(username) && "Admin@17".equals(password);
		
		if(isValid) 
		{
			
			HttpSession session = request.getSession();
			session.setAttribute("LOGGED_IN_USER", username);
			session.setAttribute("ROLE", "ADMIN");
			response.sendRedirect("AddBreedTypes.jsp");
			
		}
		else
		{
			response.sendRedirect("AdminLogin.jsp?errorMessage=Invalid Login Credentials");
		}
	}
}