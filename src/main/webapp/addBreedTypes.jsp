<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Add Breeds</title>
<style type="text/css">
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
	<h1 id="heading">Add Breed Details</h1>
		<form action="AddBreedServlet" method="post">
			<table>
				<caption>Breed Details</caption>
				<tr>
					<th scope="col">Breed Name : </th>
					<td><input type="text" name="breedName" pattern="[A-Za-z\s]{3,}" title="Name must have 3 Character"
						placeholder="Enter breed name" id="breedId" required autofocus></td>
				</tr>
				<tr>
					<th scope="col">Breed Count : </th>
					<td><input type="number" name="countId" onchange="ValidCount()"
						placeholder="Enter Breed Count" id="countId" required></td>
				</tr>
				<tr>
					<th scope="col">Price/Dog(Rs)</th>
					<td><input type="number" name="costId" onchange="validCost()"
						placeholder="Enter Cost/Dog" id="costId" required></td>
				</tr>

			</table>
			<button type="submit" class="btn btn-success">Add Breed</button>
		</form>
		<br /> <a href="adminView.jsp" class="btn btn-primary">View</a> <a
			href="displayBreedTypes.jsp" class="btn btn-danger">Delete</a>
			<a href="viewOrder.jsp" class="btn btn-success">View Order</a>
			<script>
			
			function validCost() {
				let cost = document.querySelector("#costId").value;
				if (cost>0) {
				} else {
					alert("Invalid Cost");
					event.preventDefault();
				}
			}
			function ValidCount() {
				let count = document.querySelector("#countId").value;
				if (count > 0) {
				} else {
					alert("Invalid Count");
					event.preventDefault();
				}
			}
			</script>
	</main>
</body>
</html>