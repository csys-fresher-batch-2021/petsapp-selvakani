package in.selva.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.selva.service.BreedService;
import in.selva.validator.BreedValidator;

/**
 * Servlet implementation class AddBooksServlet
 */
@WebServlet("/AddBreedServlet")

public class AddBreedServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String breedName = request.getParameter("breedName");
			boolean isValidName = BreedValidator.isBreedNameValid(breedName);
			String count = request.getParameter("count");
			int countNo = Integer.parseInt(count);
			boolean validCount = BreedValidator.isValidNumber(countNo);
			String price = request.getParameter("cost");
			double cost = Double.parseDouble(price);
			boolean validCost = BreedValidator.isCostValid(cost);

			boolean isAdded = false;
			if (isValidName && validCount && validCost) 
			{

				isAdded = BreedService.addBreed(breedName, countNo, cost);
				if (isAdded)
				{
					String message="Successfully Added Breed Details";
					response.sendRedirect("displayBreedTypes.jsp?Message : "+message );
				} 
				else 
				{
					String errorMessage = "Unable to add Books ";
					
					response.sendRedirect("AddBreedTypes.jsp?errorMessage=" + errorMessage);
				}
			}
              
		} catch (Exception e) {
			response.sendRedirect("AddBreedTypes.jsp?errorMessage=Not able to add");
		
		}

	}
}