<%@page import="java.util.* " %>
<%@page import="in.selva.model.*" %>
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
      List<BreedTypes> breedTypes = BreedService.getBreedTypes();
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
   <!--  TODO: Only Admin should be able to view this link -->
				<a href="AddBreedTypes.jsp" >Add Breed Types</a>
</form>
		
	</main>
</body>
</html>

