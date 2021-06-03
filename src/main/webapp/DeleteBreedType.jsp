<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page import="in.selva.model.*"%>
<%@ page import="in.selva.service.*"%>
<%@ page import="in.selva.dao.BreedDao" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Online Pets Sales App</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
<form action="login.jsp" method="post">
		<h3>Pets Paw</h3>
		<table class="table table-bordered">
			<caption></caption>
			<thead>
				<tr>
					<th scope="col">S.No</th>
					<th scope="col">Breed Type</th>
					<th scope="col">Price(Rs)/Dog</th>
					
					<%
					
					List<BreedTypes> breeds = BreedDao.getBreed();
					int i = 0;
					for (BreedTypes breedDetails : breeds)
					{
						i++;
					%>
				
				<tr>
					<td><%=i%></td>
					<td><%=breedDetails.getBreedType()%></td>
					<td><%=breedDetails.getCount()%></td>
					<td><%=breedDetails.getCost()%></td>
					<td><a href="DeleteBreedServlet?breedName=<%=breedDetails.getBreedType()%>" class="btn btn-danger">Delete</a></td>
				</tr>
				<%
				}
				%>
			</thead>
		</table>
       <button type="submit">Order</button>
</form>
	
		<!-- <a href="AddBreedTypes.jsp">Add Breed Type</a> -->
	</main>
</body>
</html>