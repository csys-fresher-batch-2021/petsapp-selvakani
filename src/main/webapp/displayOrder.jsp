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
#heading{
  color:#04AA6D;
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">

		<form action="BillServlet" method="post">
			<h3 id="heading">Your Cart</h3>
			<table class="table table-bordered" id="breeds">
				<caption></caption>
				<thead>
					<tr>
						<th scope="col">S.No</th>
					<th scope="col">Breed Name</th>
					<th scope="col">Count</th>
					<th scope="col">Price</th>

					</tr>

					<%
					OrderDao orderDao = new OrderDao();
					List<Order> orders = OrderDao.getConfirmOrder();
					int i = 0;
					for (Order orderDetails : orders) {
						i++;
					%>

					<tr>
						<td><%=i%></td>
						<td><%=orderDetails.getBreedName()%></td>
						<td><%=orderDetails.getCount()%></td>
						<td><%=orderDetails.getCount()*orderDetails.getCost()%> Rs</td>
						<%-- <td><a
							href="DeleteCartServlet?bookName=<%=orderDetails.getBookName()%>"
							class="btn btn-danger">CANCEL</a></td> --%>

					</tr>
					<%
					}
					%>

				</thead>
			</table>
			<button class="btn btn-success">Bill</button>
			<a href="addCart.jsp" class="btn btn-primary">Want More</a>
		</form>
	</main>
</body>
</html>