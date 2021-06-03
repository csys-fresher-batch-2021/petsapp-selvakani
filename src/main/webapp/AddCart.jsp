<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page import="in.selva.model.*"%>
<%@ page import="in.selva.dao.BreedDao"%>
<%@ page import="in.selva.service.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add to Cart</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form method="post">

			<h3>Breed Types</h3>
			<table class="table table-bordered">
				<caption></caption>
				<thead>
					<tr>
						<th scope="col">S.NO</th>
						<th scope="col">Breed Type</th>
						<th scope="col">Count</th>
						<th scope="col">Price(Rs)/Dog</th>

						<%
						BreedDao breedDao = new BreedDao();
						List<BreedTypes> breeds = BreedDao.getBreed();
						int i = 0;
						for (BreedTypes breedDetails : breeds) {
							i++;
						%>
					
					<tr>
						<td><%=i%></td>
						<td><%=breedDetails.getBreedType()%></td>
						<td><%=breedDetails.getCount()%></td>
						<td><%=breedDetails.getCost()%></td>
						<td><a
							href="OrderBreedServlet?breedName=<%=breedDetails.getBreedType()%>"
							class="btn btn-success">Add to Cart</a></td>
					</tr>
					<%
					}
					%>
				</thead>
			</table>


		</form>

		<a href="ViewCart.jsp" class="btn btn-success">View Cart</a>
	</main>
</body>
</html>