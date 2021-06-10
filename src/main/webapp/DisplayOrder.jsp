<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@ page import="in.selva.model.Order"%>
<%@ page import="in.selva.dao.OrderDao"%>
<%@ page import="in.selva.service.OrderService"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Orders</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">

		<form action="BillServlet" method="post">
			<h3>Books</h3>
			<table class="table table-bordered">
				<caption></caption>
				<thead>
					<tr>
						<th scope="col">S.No</th>
						<th scope="col">Breed Name</th>
						<th scope="col">Total Count</th>
						<th scope="col">Cost</th>
						<th scope="col">Buy More</th>

					</tr>

					<%
					OrderDao orderDao = new OrderDao();
					List<Order> orders = OrderService.getOrderDetails();
					int i = 0;
					for (Order orderDetails : orders) {
						i++;
					%>

					<tr>
						<td><%=i%></td>
						<td><%=orderDetails.getBreedType()%></td>
						<td><%=orderDetails.getCount()%></td>
						<td><%=orderDetails.getCost()%> Rs</td>
						<td><a
							href="DeleteCartServlet?breedName=<%=orderDetails.getBreedType()%>"
							class="btn btn-danger">Cancel</a></td>

					</tr>
					<%
					}
					%>

				</thead>
			</table>
			<button class="btn btn-success">Bill</button>
			<a href="AddCart.jsp" class="btn btn-primary">Buy More</a>
		</form>
	</main>
</body>
</html>