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

		try {
			String breedName = request.getParameter("breedName");

			int count = BreedService.getCount(breedName);
			double cost = BreedService.getBreedCost(breedName);
			boolean isAdded = false;
			
			
				isAdded = OrderService.addOrder(breedName, count, cost);
				if (isAdded) 
				{
					response.sendRedirect("viewCart.jsp");
				}
				else
				{
					response.sendRedirect("viewCart.jsp?Invalid Count");
				}

			
		} catch (Exception e) {
			response.sendRedirect("addCart.jsp?errorMessage=Unable to add");
		}

	}
}