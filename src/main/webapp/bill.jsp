<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@ page import="in.selva.model.*"%>
<%@ page import="in.selva.dao.UserDao"%>
<%@ page import="in.selva.service.UserService"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Bill Estimation</title>
</head>
<style>
#heading{
  color:#04AA6D;
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}
</style>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
    
	<%
	String userName = (String) session.getAttribute("LOGGED_IN_USER");
	Double total = (Double) session.getAttribute("TOTAL");
	String timeStamp = new SimpleDateFormat("dd-MM-yyy  HH:mm:ss").format(Calendar.getInstance().getTime());
	%>
	<h3 id="heading">Estimated Bill</h3>
	<table class="table table-bordered" border='1'>
	<caption></caption>
		<thead>
		</thead>
		<tr>
			<th scope="col">User Name : </th>
			<td><%=userName%></td>

		</tr>
		           <%
		           
					List<User> users = UserDao.getUserDetails(userName);
					
					for (User userDetails : users) {
						
					%>
					<tr>
					<th scope="col">User Id : </th>
					<td><%=userDetails.getId() %></td>
					</tr>
					<tr>
					<th scope="col">Email Id : </th>
					<td><%=userDetails.getEmail() %></td>
					</tr>
					<tr>
					<th scope="col">Mobile Number : </th>
					<td><%=userDetails.getMobile() %></td>
					</tr>
					<tr>
					<th scope="col">Address : </th>
					<td><%=userDetails.getAddress() %></td>
					</tr>
					
					<tr>
					<th scope="col">Ordered Date&Time : </th>
					<td><%=timeStamp %></td>
					</tr>
			
				<%
				break;}
				%>
		<tr>
            <th scope="col">Total Amount : </th>
			<td><%=total%> Rs</td>
		</tr>
	</table>
<a href="addCart.jsp" class="btn btn-primary">Pay</a>
	
		</main>
</body>
</html>