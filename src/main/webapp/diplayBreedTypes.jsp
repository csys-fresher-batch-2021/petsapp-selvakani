<%@page import="java.util.* " %>
<%@page import="in.selva.service.*" %>
<!DOCTYPE html>
<html>
<html lang="en" xml:lang="en">
<head>
<title>Online Pets Sales App</title>
<meta content="text/html; charset=utf-8" />
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Display Breed Types</h3>
		<form>
     <table class="table table-bordered" border="2">
     <caption>Breed Types In Pets Paw</caption>
     <thead>
     <th scope="col">S.No</th>
     <th scope="col">Breed Type</th>
     <th scope="col">Price/Dog</th>
     </thead>
     <tbody>
      <%
      List<BreedTypes> breedTypes = DisplayBreedTypes.addBreedTypesDetails();
      int i=0;
      for(BreedTypes breedType : breedTypes){
    	  i++;
      %>
      <tr>
         <td><%=i %>
         <td><%= breedType.breedType %></td>
         <td><%= breedType.price %></td>
     </tr>
     <% } %>
     </tbody>
   </table>
</form>
		
	</main>
</body>
</html>

