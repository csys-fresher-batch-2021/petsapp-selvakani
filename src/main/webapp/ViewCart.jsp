<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
    <%@page import="java.util.Map"%>
<%@ page import="in.selva.model.Order"%>
<%@ page import="in.selva.dao.OrderDao"%>
<%@ page import="in.selva.service.OrderService"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Cart</title>
</head>
<body>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">


		<h3>Pets Paw</h3>
		<table class="table table-bordered">
			<caption></caption>
			<thead>
				<tr>
					<th scope="col">S.No</th>
					<th scope="col">Breed Type</th>
					<th scope="col">Total Count</th>
					<th scope="col">Cost</th>
					<th scope="col">Ordered</td></th>
					
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
					<td><%=orderDetails.getBreedType() %></td>
					<td><%=orderDetails.getCount() %></td>
					<td><%=orderDetails.getCost() %></td>
					
				
					<td><form action="ConfirmOrderServlet" method="post"> <input type="number" name="noBreed"
					placeholder="Enter Count" id="countId" required ></form></td>
					<td><button type="submit" class="btn btn-success">Confirm Order</button></td>
					<td><a href="DeleteBreedServlet?breedName=<%=orderDetails.getBreedType() %>" class="btn btn-danger">Delete</a></td>
				</tr>
				<%
				}
				%>
			</thead>
		</table>
      
     
	
	 <a href="ViewCart.jsp" class="btn btn-primary">View Response</a>
	</main>
</body>
</html>