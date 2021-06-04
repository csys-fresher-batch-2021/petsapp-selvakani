
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<h3>User Login</h3>
		<form action="UserLoginServlet" method="post">
			<table>
				<caption>User Login</caption>
				<tr>
					<th scope="col">User Name</th>
					<td><input type="text" name="userName"
						placeholder="Enter user name" id="userId" required autofocus></td>
				</tr>
				<tr>
					<th scope="col">Password</th>
					<td><input type="password" name="passCode"
						placeholder="Enter password" id="passId" required></td>
				</tr>
			</table>
			<button type="submit" class="btn btn-success">Submit</button>
			<a href="UserRegistration.jsp" class="btn btn-primary">New User</a>
		</form>
	</main>
</body>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="UserLoginServlet" method="post">
			<table>
				<caption>Welcome To Pets Paw</caption>
				<tr>
					<th scope="col">User Name</th>
					<td><input type="text" name="userName"
						placeholder="Enter user name" id="userId" required autofocus></td>
				</tr>
				<tr>
					<th scope="col">Password</th>
					<td><input type="password" name="passCode"
						placeholder="Enter password" id="passId" required></td>
				</tr>
			</table>
			<button type="submit" class="btn btn-success">Submit</button>
			<a href="UserRegistration.jsp" class="btn btn-primary">New User</a>
		</form>
	</main>
</body>
</html>