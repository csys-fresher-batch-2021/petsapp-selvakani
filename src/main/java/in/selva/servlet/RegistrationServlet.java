package in.selva.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.selva.service.BreedService;
import in.selva.service.UserService;
/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	    try 
	    {
	    	String username = request.getParameter("userName");
			String email = request.getParameter("email");
			String mobileNumber = request.getParameter("mobile");
			long userMobileNum = Long.parseLong(mobileNumber);
			String address = request.getParameter("address");
			String password = request.getParameter("pass");
			
			UserService service = new UserService();
			
			boolean isAdded = service.addDetails(username, email, userMobileNum, address, password);
			
			if(isAdded) 
			{
				response.sendRedirect("UserLogin.jsp");
				System.out.println("valid");
			}
			
	    }
	    catch(Exception e) 
	    {
			String errorMessage = "Invalid user details ";
			System.out.println("Invalid");
			response.sendRedirect("UserRegistration.jsp?errorMessage=" + errorMessage);
		}

}
}