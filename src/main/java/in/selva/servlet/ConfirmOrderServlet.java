package in.selva.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.selva.dao.OrderDao;
import in.selva.service.OrderService;

/**
 * Servlet implementation class ConfirmOrderServlet
 */

@WebServlet("/ConfirmOrderServlet")

public class ConfirmOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String total = request.getParameter("count");
			int count = Integer.parseInt(total);
			HttpSession session = request.getSession();
			String breedName = (String) session.getAttribute("breedName");
			boolean valid = OrderService.validCount(breedName, count);
			int totalCount = OrderService.getUpdatedBreed(breedName);
			System.out.println("Total from order list : " + totalCount);

			boolean updated = OrderDao.updateBreeds(breedName, totalCount - count);
			if (valid && updated) {
				boolean added = OrderService.addConfirmOrder(breedName, count);
				if (added) {
					response.sendRedirect("DisplayOrder.jsp");
				} else {
					response.sendRedirect("ViewCart.jsp?errorMessage=Unable to add");
				}
			}
		} catch (Exception e) {
			response.sendRedirect("ViewCart.jsp?errorMessage=Invalid No Of Books");
		}

	}

}