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
 * Servlet implementation class OrderBookServlet
 */

@WebServlet("/OrderBreedServlet")

public class OrderBreedServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{

		try 
		{
			String breedType = request.getParameter("breedName");
			int count = BreedService.getCount(breedType);
			double cost = BreedService.getBreedCost(breedType);
			boolean added = false;
			boolean present = OrderService.isPresent(breedType);
			if (!present) 
			{
				added = OrderService.addOrder(breedType, count, cost);
				HttpSession sess = request.getSession();
				String role = (String) sess.getAttribute("JOB");
				if (added && role != "SEARCHING")
				{
					response.sendRedirect("viewCart.jsp");
				} 
				else if (added && role == "SEARCHING")
				{
					response.sendRedirect("userSearchDisplay.jsp");
				}

			}
		} 
		catch (Exception e)
		{
			String errorMessage = "Unable to add";
			response.sendRedirect("addCart.jsp?errorMessage=" + errorMessage);
		}

	}
}