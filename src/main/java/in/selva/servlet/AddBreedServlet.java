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

public class AddBreedServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public AddBreedServlet()
    {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		PrintWriter out = response.getWriter();
		System.out.println("AddBreedServlet");
		
		// Step 1: Get Form Values
		
		String breedType = request.getParameter("breedType");
		out.println(breedType);
		int count=Integer.parseInt(request.getParameter("count"));;
		out.println(count);
		int price = Integer.parseInt(request.getParameter("price"));
		out.println(price);
		
		// Step 2: Call Service => Add breed types
		
		
		boolean isAdded = BreedService.addBreed(breedType,count,price);
		
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


