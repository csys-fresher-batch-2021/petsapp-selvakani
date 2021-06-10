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
			
			<script>
			
			function validCost() {
				let cost = document.querySelector("#costId").value;
				if (cost>0)
				{
				} else {
					alert("Invalid Cost");
					event.preventDefault();
				}
			}
			function ValidCount() {
				let noOfBooks = document.querySelector("#countId").value;
				if (noOfBooks>0) {
				} else {
					alert("Incorrect Count");
					event.preventDefault();
				}
			}
			</script>
	</main>
</body>
</html>