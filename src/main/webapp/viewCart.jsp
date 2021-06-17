<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
    <%@page import="java.util.Map"%>
<%@ page import="in.selva.model.Order"%>
<%@ page import="in.selva.dao.OrderDao"%>
<%@ page import="in.selva.service.OrderService"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
<style>
#breeds {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}
#breeds td, #breeds th {
  border: 1px solid #ddd;
  padding: 8px;
}
#breeds tr:nth-child(even){background-color: #f2f2f2;}
#breeds tr:hover {background-color: #ddd;}
#breeds th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}
</style>
</head>
<body>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
      <h3>Books</h3>
		<table class="table table-bordered" id="breeds">
			<caption></caption>
			<thead>
				<tr>
					<th scope="col">S.No</th>
					<th scope="col">Breed Name</th>
					<th scope="col">Count</th>
					<th scope="col">Price</th>
					<th scope="col">Ordered</th>
					<th scope="col">Confirm</th>
					<th scope="col">Delete</th>
					
					<%
					HttpSession sess = request.getSession();
					session.setAttribute("JOB", "REMOVE");
					OrderDao orderDao = new OrderDao();
					List<Order> orders = OrderDao.getOrder();
					int i = 0;
					for (Order orderDetails : orders) {
						i++;
					%>
				
				<tr>
					<td><%=i%></td>
					<td><%=orderDetails.getBreedName() %></td>
					<td><%=orderDetails.getCount() %></td>
					<td><%=orderDetails.getCost() %> Rs</td>
					
				
					<td><form action="ConfirmOrderServlet"> <input type="number" name="count"
					placeholder="Enter Count" id="countId" required ></td>
					<td><button class="btn btn-success"  type="submit">Confirm Order</button></td>
					
					<td><a href="DeleteBreedServlet?breedName=<%=orderDetails.getBreedName()%>" class="btn btn-danger">Delete</a></td>
				</tr>
				<%
				session.setAttribute("breedName",orderDetails.getBreedName());
				%>
				</form>
		   <%
			}
			%>
		</thead>
		</table>
	
				 
		
    <a href="addCart.jsp" class="btn btn-primary">Want More</a>
    <a href="displayOrder.jsp" class="btn btn-primary">View</a>
	
	
	</main>
</body>
</html>