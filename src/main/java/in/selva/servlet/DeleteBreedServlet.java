package in.selva.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.selva.service.BreedService;
import in.selva.service.OrderService;

/**
 * Servlet implementation class DeleteBookServlet
 */

@WebServlet("/DeleteBreedServlet")
public class DeleteBreedServlet extends HttpServlet 

{
	private static final long serialVersionUID = 1L;
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
    {
		try 
		{
			String breedType = request.getParameter("breedName");
			HttpSession sess = request.getSession();
			boolean isDeleted = false;
			boolean isOrderDeleted = false;
			String role = (String) sess.getAttribute("JOB");
			if (role != "REMOVE") 
			{
				isDeleted = BreedService.deleteBreed(breedType);
				
				if (isDeleted)
				{
					response.sendRedirect("displayBreedTypes.jsp");
				} 
				else 
				{

					String errorMessage = "Unable to delete Breed Type";
					response.sendRedirect("AddBreedTypes.jsp?errorMessage=" + errorMessage);
				}
			} 
			else 
			{
				isOrderDeleted = OrderService.deleteBreed(breedType);
				if (isOrderDeleted) 
				{
					response.sendRedirect("ViewCart.jsp");

				}
			}
		} 
		catch (Exception e) 
		{

			String errorMessage = "Unable to delete Breed Type";
			response.sendRedirect("ViewCart.jsp?errorMessage=" + errorMessage);
		}
	}

}