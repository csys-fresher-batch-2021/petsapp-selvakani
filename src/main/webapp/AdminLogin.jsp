<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<h3>Admin Login</h3>
		<form action="LoginServlet" method="post">
			<table>
				<caption>Admin Login</caption>
				<tr>
					<th scope="col">User Name</th>
					<td><input type="text" name="userName"
						placeholder="Enter user name" id="userId" required autofocus></td>
				</tr>
				<tr>
					<th scope="col">Password</th>
					<td><input type="password" name="password"
						placeholder="Enter password" id="passId" required></td>
				</tr>
			</table>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</main>
</body>
</html>
