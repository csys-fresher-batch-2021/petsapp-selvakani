 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Breed Types</title>
</head>
<body>
<h1>Add Breed Types</h1>
	<form action="AddBreedTypes" method="post">
<table>
        <tr><td>Breed Type : </td>
            <td><input type="text" name="breedType" placeholder = "Enter Breed Name" id="breedId"required autofocus></td>
            </tr>
    	<tr><td>Price : </td>
    <td><input type="number" name="price" placeholder="Enter Price / Dog" id="priceId" required></td>
    </tr>
</table>
<button type="submit">SUBMIT</button>
</form>
</body>
</html>