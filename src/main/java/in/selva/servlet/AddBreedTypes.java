package in.selva.servlet;

import in.selva.service.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddBreedTypes
 */
@WebServlet("/AddBreedTypes")
public class AddBreedTypes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBreedTypes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		System.out.println("AddProductServlet");
		
		// Step 1: Get Form Values
		
		String breedType = request.getParameter("breedType");
		out.println(breedType);
		int price = Integer.parseInt(request.getParameter("price"));
		out.println(price);
		
		// Step 2: Call Service => add Product
		
		boolean isAdded = BreedService.addBreedType(breedType,price);
		
		// Step 3: Decide to which page we should redirect ?
		
		if (isAdded)
		{
			response.sendRedirect("displayBreedTypes.jsp");
		} 
		else 
		{
			String errorMessage = "Unable to Add Breed Types ";
			response.sendRedirect("AddBreedTypes.jsp?errorMessage=" + errorMessage);
		}
		
	}

}


