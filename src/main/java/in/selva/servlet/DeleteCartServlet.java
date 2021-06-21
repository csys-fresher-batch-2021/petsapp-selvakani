package in.selva.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.selva.dao.OrderDao;
import in.selva.service.OrderService;

/**
 * Servlet implementation class DeleteCartServlet
 */

@WebServlet("/DeleteCartServlet")

public class DeleteCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
			boolean delete = false;
			
			String name = request.getParameter("breedName");
			delete = OrderService.deleteCart(name);
			int totalCount = OrderService.getUpdatedBreeds(name);
			
			int count = OrderDao.getCount(name);
			
		
		    boolean updated =  OrderDao.updateBreeds(name, totalCount+count);
		    if(delete && updated) {
		    	response.sendRedirect("displayOrder.jsp");
		    }
			
			
		}catch(Exception e) {
			response.sendRedirect("viewCart.jsp?errorMessage=Unable to delete item");
		} 
	}

}