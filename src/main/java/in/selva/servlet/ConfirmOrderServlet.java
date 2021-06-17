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
 * Servlet implementation class CofirmOrderServlet
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
			
			int totalCount = OrderService.getUpdatedBreeds(breedName);
			
            
			boolean updated = OrderDao.updateBreeds(breedName, totalCount - count);
			
			if (valid && updated) 
			{
				HttpSession sess = request.getSession();
				String userName = (String) sess.getAttribute("LOGGED_IN_USER");
				boolean added = OrderService.addConfirmOrder(userName,breedName, count);
				
				if (added) {
					response.sendRedirect("displayOrder.jsp");
				} else {
					response.sendRedirect("viewCart.jsp?errorMessage=Unable to add");
				}
			}
		} catch (Exception e) {
			response.sendRedirect("viewCart.jsp?errorMessage=Invalid Count");
		} 

	}

}