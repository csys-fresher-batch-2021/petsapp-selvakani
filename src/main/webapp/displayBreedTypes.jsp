<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page import="in.selva.model.*"%>
<%@ page import="in.selva.dao.BreedDao"%>
<%@ page import="in.selva.service.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Pets Shop</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		

			<h3>Pets Paw</h3>
			<table class="table table-bordered">
				<caption></caption>
				<thead>
					<tr>
						<th scope="col">S.NO</th>
						<th scope="col">Breed Name</th>
						<th scope="col">Count</th>
						<th scope="col">Price(Rs)/Dog</th>

						<%
						BreedDao breedDao = new BreedDao();
						List<BreedTypes> breeds = breedDao.getBreed();
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
						<td><a
							href="DeleteBreedServlet?breedName=<%=breedDetails.getBreedType()%>"
							class="btn btn-danger">Delete</a></td>
					</tr>
					<%
					}
					%>
				</thead>
			</table>

			
	

		
	</main>
</body>
</html>