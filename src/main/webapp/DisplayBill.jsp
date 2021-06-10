<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page import="in.selva.model.*"%>
<%@ page import="in.selva.dao.OrderDao"%>
<%@ page import="in.selva.service.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>BILL</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="Login.jsp" method="post">

			<h3>Books</h3>
			<table class="table table-bordered">
				<caption>bill</caption>
				<thead>
					<tr>
						<th scope="col">S.No</th>
						<th scope="col">Breed Name</th>
						<th scope="col">Count</th>
						<th scope="col">Cost</th>
						<th scope="col">Total</th>


						<%
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
						<td><%=orderDetails.getCount() * orderDetails.getCost()%> Rs</td>
					</tr>
					<%
					}
					%>
				</thead>
			</table>

		</form>
		<%
		String userName = (String) session.getAttribute("LOGGED_IN_USER");
		Double total = (Double) session.getAttribute("TOTAL");
		%>
		<h1>YOUR TOTAL BILL</h1>
		<table class="table table-bordered">
			<thead>
			</thead>
			<tr>
				<th scope="col">User Name </th>
				<th scope="col">Total Amount(Rs) </th>
			</tr>
			<tr>
				<td><%=userName%>
				<td><%=total%>
			</tr>
		</table>

		<a href="AddCart.jsp" class="btn btn-success">Confirm Order</a>
	</main>
</body>
</html>