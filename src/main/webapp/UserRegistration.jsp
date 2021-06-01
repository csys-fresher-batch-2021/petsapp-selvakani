<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
<form action="RegistrationServlet" method="post">
<table>
			<caption><h3>... Register Yourself ...</h3></caption>
			<tr>
				<th scope="col">Name : </th>
				<td><input type="text" name="userName"
					placeholder="Enter User name" id="userId" required autofocus></td>
			</tr>
			<tr>
				<th scope="col">Email Id : </th>
				<td><input type="email" name="email"
					placeholder="Enter Your Email Id" id="emailId" required></td>
			</tr>
				<tr>
				<th scope="col">Mobile Number : </th>
				<td><input type="number" name="mobile"
					placeholder="Enter mobile number" id="mobileId" required></td>
		
				<tr>
				<th scope="col">Address: </th>
				<td><input type="text" name="address"
					placeholder="Enter Your Address" id="addressId" required></td>
			</tr>
			<tr>
				<th scope="col">Password : </th>
				<td><input type="password" name="pass"
					placeholder="Enter Password" id="passId" required></td>
			</tr>
			</table>
			<button type="submit">Register</button>
			</form>
</body>
</body>
</html>