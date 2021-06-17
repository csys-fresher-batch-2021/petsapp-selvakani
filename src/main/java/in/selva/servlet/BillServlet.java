package in.selva.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import in.selva.service.OrderService;

/**
 * Servlet implementation class BillServlet
 */

@WebServlet("/BillServlet")

public class BillServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			double total = OrderService.billCalculation();
			
			HttpSession session = request.getSession();
			if(total!=0) {
			    session.setAttribute("TOTAL", total);
				response.sendRedirect("bill.jsp");
			}
		}catch(Exception e) {
			response.sendRedirect("addCart.jsp?errorMessage=No items in cart");
			
		}
	}

}