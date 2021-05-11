<%@page import="java.util.* " %>
<%@page import="in.selva.service.*" %>
<html>
<head>
<title>Online Pets Sales App</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Display Breed Types</h3>
		<form>
     <table class="table table-bordered" border="2">
     <thead>
     <th>S.No</th>
     <th>Breed Type</th>
     <th>Price/Dog</th>
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

