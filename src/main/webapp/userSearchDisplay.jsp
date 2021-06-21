<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="java.util.Map"%>
<%@ page import="in.selva.model.*"%>
<%@ page import="in.selva.dao.BreedDao"%>
<%@ page import="in.selva.service.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>User Search</title>
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
<form method="post">
   <h3>Pets Paw</h3>
		<table class="table table-bordered" id="breeds">
			<caption></caption>
			<thead>
				<tr>
				   <%
				   HttpSession sess = request.getSession();
				   session.setAttribute("JOB", "SEARCHING");
				   String role = (String) session.getAttribute("ROLE");
				   String user = (String) session.getAttribute("LOGGED_IN_USER");
				   
					if(role =="ADMIN" || user == null) {
					%>
				    <th scope="col">S.No</th>
					<th scope="col">Breed Name</th>
					<th scope="col">Count</th>
					<th scope="col">Price/Dog</th>
					
					<%
					BreedDao breedDao = new BreedDao();
					List<BreedTypes> cost = BreedDao.getSearch();
					int i = 0;
					for (BreedTypes breedDetails : cost) {
						i++;
					%>
				
				<tr>
					<td><%=i%></td>
					<td><%=breedDetails.getBreedName() %></td>
					<td><%=breedDetails.getCount() %></td>
					<td><%=breedDetails.getCost() %> Rs</td>
					
				</tr>
				<%
				}
				%>
				</thead>
		</table>
				
					<%
					} else {
					%>
		
		<table class="table table-bordered">
			<caption></caption>
			<thead>	
						
					<th scope="col">S.No</th>
					<th scope="col">Breed Name</th>
					<th scope="col">Count</th>
					<th scope="col">Price/Dog</th>
					
					<%
					BreedDao breedDao = new BreedDao();
					List<BreedTypes> cost = BreedDao.getSearch();
					int i = 0;
					for (BreedTypes breedDetails : cost) {
						i++;
					%>
				
				<tr>
					<td><%=i%></td>
					<td><%=breedDetails.getBreedName() %></td>
					<td><%=breedDetails.getCount() %></td>
					<td><%=breedDetails.getCost() %></td>
					<td><a href="OrderBreedServlet?breedName=<%=breedDetails.getBreedName()%>" class="btn btn-success">Add To Cart</a></td>
				</tr>
				<%
				}
				%>
					</thead>
		</table>
				<a href="viewCart.jsp" class="btn btn-success">View Cart</a>
						<%
					    }
						%>    
	</form>
</main>
</body>
</html>