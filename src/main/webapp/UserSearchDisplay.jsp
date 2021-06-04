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
<title>Pet Shop</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
<form method="post">

		<h3>Pets Paw</h3>
		<table class="table table-bordered">
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
					<th scope="col">S.NO</th>
					<th scope="col">Breed Type</th>
					<th scope="col">Count</th>
					<th scope="col">Price(Rs)/Dog</th>
					
					<%
					BreedDao breedDao = new BreedDao();
					List<BreedTypes> breed = BreedDao.getSearch();
					int i = 0;
					for (BreedTypes breedDetails : breed) 
					{
						i++;
					%>
				
				<tr>
					<td><%=i%></td>
					<td><%=breedDetails.getBreedType() %></td>
					<td><%=breedDetails.getCount() %></td>
					<td><%=breedDetails.getCost() %></td>
					
				</tr>
				<%
				}
				%>
				</thead>
		</table>
				
					<%
					} 
					else 
					{
					%>
		
		<table class="table table-bordered">
			<caption></caption>
			<thead>	
						
					<th scope="col">S.NO</th>
					<th scope="col">Breed Type</th>
					<th scope="col">Count</th>
					<th scope="col">Price(Rs)/Dog</th>
					
					<%
					BreedDao breedDao = new BreedDao();
					List<BreedTypes> breed = BreedDao.getSearch();
					int i = 0;
					for (BreedTypes breedDetails : breed) 
					{
						i++;
					%>
				
				<tr>
					<td><%=i%></td>
					<td><%=breedDetails.getBreedType() %></td>
					<td><%=breedDetails.getCount() %></td>
					<td><%=breedDetails.getCost() %></td>
					<td><a href="OrderBreedServlet?breedName=<%=breedDetails.getBreedType()%>" class="btn btn-success">Add To Cart</a></td>
				</tr>
				<%
				}
				%>
					</thead>
		</table>
				<a href="ViewCart.jsp" class="btn btn-success">View Cart</a>
						<%
					    }
						%>      
</form>
	</main>
</body>
</html>