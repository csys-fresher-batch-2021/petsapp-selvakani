<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
    <%@page import="java.time.format.DateTimeFormatter"%>
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
#breeds td, #books th {
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
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
      <h3 id="heading">View Ordered</h3>
		<table class="table table-bordered" id="breeds">
			<caption></caption>
			<%
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
		
			%>
			<thead>
				<tr>
					<th scope="col">Order Id</th>
					<th scope="col">User Id</th>
					<th scope="col">User Name</th>
					<th scope="col">Breed Name</th>
					<th scope="col">Total Count</th>
					<th scope="col">Price</th>
					
					<th scope="col">Ordered Date</th>
					<th scope="col">Deliver Date</th>
					<th scope="col">Status</th>
					<th scope="col">Deliver</th>
					<th scope="col">Cancel</th>
					
					<%
					
					OrderDao orderDao = new OrderDao();
					List<Order> orders = OrderDao.getOrderDetails();
					
					int i = 0;
					for (Order orderDetails : orders) {
						i++;
					%>
				
				<tr>
					<%-- <td><%=i%></td> --%>
					<td><%=orderDetails.getId() %></td>
					<td><%=orderDetails.getUserId() %></td>
					<td><%=orderDetails.getUserName() %></td>
					<td><%=orderDetails.getBreedName() %></td>
					<td><%=orderDetails.getCount() %></td>
					<td><%=orderDetails.getCost() %> Rs</td>
					
					<td><%=formatter.format(orderDetails.getOrderDate()) %> </td>
					<td><%=formatter.format(orderDetails.getDeliveryDate()) %> </td>
					
					<td><%=orderDetails.getStatus() %></td>
					<td><a href="AcceptOrderServlet?orderId=<%=orderDetails.getId() %>" class="btn btn-success">Delivered</a></td>
					<td><a href="RejectOrderServlet?orderId=<%=orderDetails.getId()%>" class="btn btn-danger">Cancelled</a></td>
				<%-- <td><a
							href="OrderBreedServlet?breedName=<%=breedDetails.getBreedName()%>"
							class="btn btn-success">Add To Cart</a></td> --%>
					
				</tr>
				
		   <%
			}
			%>
		</thead>
		</table>
	<a href="addBreedTypes.jsp" class="btn btn-primary">Back</a>
	
	</main>

</body>
</html>