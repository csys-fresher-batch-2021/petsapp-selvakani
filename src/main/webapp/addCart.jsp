<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page import="in.selva.model.*"%>
<%@ page import="in.selva.dao.BreedDao"%>
<%@ page import="in.selva.service.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Add Cart</title>
<style>
#breedss {
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
		<form method="post">

			<h3 id="heading">Book Now</h3>
			<table class="table table-bordered" id="breeds">
				<caption></caption>
				<thead>
					<tr>
						<th scope="col">S.No</th>
					<th scope="col">Breed Name</th>
					<th scope="col">Count</th>
					<th scope="col">Price/Dog(Rs)</th>
						<th scope="col">Cart</th>

						<%
						BreedDao breedDao = new BreedDao();
						List<BreedTypes> breeds =  BreedDao.getBreedDetails();
						int i = 0;
						for (BreedTypes breedDetails : breeds) {
							i++;
						%>
					
					<tr>
						<td><%=i%></td>
						<td><%=breedDetails.getBreedName()%></td>
						<td><%=breedDetails.getCount()%></td>
						<td><%=breedDetails.getCost()%> Rs</td>
						<td><a href="OrderBreedServlet?breedName=<%=breedDetails.getBreedName()%>"
							class="btn btn-primary">Add to Cart</a></td>
					</tr>
					<%
					}
					%>
				</thead>
			</table>
		</form>

		<a href="displayOrder.jsp" class="btn btn-info">View Cart</a>
		
		<a href="userOrder.jsp" class="btn btn-success">View Status</a>
	</main>
</body>
</html>