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
<title>Bill</title>
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
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="login.jsp" method="post">

			<h3>Pets Paw</h3>
			<table class="table table-bordered" id="breeds">
				<caption>Bill</caption>
				<thead>
					<tr>
						<th scope="col">S.No</th>
					<th scope="col">Breed Name</th>
					<th scope="col">Count</th>
					<th scope="col">Price/Dog</th>
						<th scope="col">Total</th>


						<%
						List<Order> orders = OrderService.getOrderDetails();
						int i = 0;
						for (Order orderDetails : orders) {
							i++;
						%>
					
					<tr>
						<td><%=i%></td>
						<td><%=orderDetails.getBreedName()%></td>
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
		
	</main>
</body>
</html>