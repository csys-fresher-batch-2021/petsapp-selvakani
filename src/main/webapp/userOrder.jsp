<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@ page import="in.selva.model.Order"%>
    <%@page import="java.time.format.DateTimeFormatter"%>
<%@ page import="in.selva.dao.OrderDao"%>
<%@ page import="in.selva.dao.UserDao"%>
<%@ page import="in.selva.service.OrderService"%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Orders</title>
<style>
.btn {
  background-color: DodgerBlue;
  border: none;
  color: white;
  padding: 12px 16px;
  font-size: 16px;
  cursor: pointer;
}
/* Darker background on mouse-over */
.btn:hover {
  background-color: RoyalBlue;
}
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

		<form action="addCart.jsp">
			<h3>Pets Paw</h3>
			<table class="table table-bordered" id="breeds">
				<caption></caption>
				<%
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
		
			%>
				<thead>
					<tr>
						<th scope="col">S.No</th>
						<th scope="col">Order Id</th>
						<th scope="col"> User Id</th>
						<th scope="col"> User Name</th>
						<th scope="col">Breed Name</th>
						<th scope="col">Total Count</th>
						<th scope="col">Price</th>
						<th scope="col">Order Date</th>
						<th scope="col">Delivery Date</th>
						<th scope="col">Status</th>

					</tr>

					<%
					OrderDao orderDao = new OrderDao();
					HttpSession sess = request.getSession();
					String userName = (String) sess.getAttribute("LOGGED_IN_USER");
					int id = UserDao.getId(userName);
					List<Order> orders = OrderDao.getUserOrder(id);
					int i = 0;
					for (Order orderDetails : orders) {
						i++;
					%>

					<tr>
						<td><%=i%></td>
						<td><%=orderDetails.getId() %></td>
						<td><%=orderDetails.getUserId() %></td>
						<td><%=orderDetails.getUserName() %></td>
						<td><%=orderDetails.getBreedName()%></td>
						<td><%=orderDetails.getCount()%></td>
						<td><%=orderDetails.getCost() %></td>
						<td><%=formatter.format(orderDetails.getOrderDate()) %> </td>
					    <td><%=formatter.format(orderDetails.getDeliveryDate()) %> </td>
						<td><%=orderDetails.getStatus() %></td>
						
					</tr>
					<%
					}
					%>

				</thead>
			</table>
			<button class="btn" type="submit"><em class="fa fa-home"></em> Home</button>
		</form>
	</main>
</body>
</html>