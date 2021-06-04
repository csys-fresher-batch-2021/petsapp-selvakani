<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Add Breed Types</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h1>Add Breed Details</h1>

		<h3><I>Add Breed Details</I></h3>

		<form action="AddBreedServlet" method="post">
			<table>
				<caption>Breed Details</caption>
				<tr>
					<th scope="col">Breed Type : </th>
					<td><input type="text" name="breedName"
						placeholder="Enter breed name" id="breedId" required autofocus></td>
				</tr>
				<tr>
					<th scope="col">Breed Count : </th>
					<td><input type="number" name="count"
						placeholder="Enter Breed Count" id="countId" required></td>
				</tr>
				<tr>
					<th scope="col">Price/Dog</th>
					<td><input type="number" name="cost"
						placeholder="Enter Cost/Dog" id="costId" required></td>
				</tr>

			</table>
			<button type="submit" class="btn btn-success">Add Breed</button>
		</form>
		<br /> <a href="View.jsp" class="btn btn-primary">View</a> <a
			href="displayBreedTypes.jsp" class="btn btn-danger">Delete</a>
	</main>
</body>
</html>