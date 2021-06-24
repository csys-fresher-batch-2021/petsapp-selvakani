package in.selva.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import in.selva.service.BreedService;

/**
 * Servlet implementation class AddBreedsServlet
 */
@WebServlet("/AddBreedServlet")

public class AddBreedServlet extends HttpServlet {
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
            String breedcount = request.getParameter("countId");
			int count = Integer.parseInt(breedcount);
            String price = request.getParameter("costId");
			double cost = Double.parseDouble(price);

			boolean isAdded = BreedService.addBreed(breedName, count, cost);
			if (isAdded) {
				response.sendRedirect("addBreedTypes.jsp");
			} else {

				response.sendRedirect("addBreedTypes.jsp?errorMessage=Unable to add Breed details");
			}

		} catch (Exception e) {
			response.sendRedirect("addBreedTypes.jsp?errorMessage=Not able to add");

		}

	}
}
