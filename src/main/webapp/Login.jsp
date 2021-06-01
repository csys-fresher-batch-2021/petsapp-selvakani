<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
<form action="UserLoginServelet" method="post">
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
			<button type="submit">Submit</button>
			<a href="userRegistration.jsp">New User</a>
</form>
</main>
</body>
</html>
