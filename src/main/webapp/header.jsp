<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet" href=" bootstrap.js">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<%
String loggedInAdminname = (String) session.getAttribute("LOGGED_IN_USER");
String role = (String) session.getAttribute("ROLE");
%>

<%
String loggedInUsername = (String) session.getAttribute("LOGGED_IN_USER");
%>
<style>
.topnav .search-container button {
  float: right;
  padding: 6px 10px;
  margin-top: 8px;
  margin-right: 16px;
  background: #ddd;
  font-size: 17px;
  border: none;
  cursor: pointer;
}
.topnav .search-container button:hover {
  background: #ccc;
}
</style>
<header>
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<a class="navbar-brand" href="#">Pets Paw</a>
		<button class="navbar-toggler d-lg-none" type="button"
			data-toggle="collapse" data-target="#collapsibleNavId"
			aria-controls="collapsibleNavId" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavId">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link"
					href="index.jsp">Home <span class="sr-only">(current)</span></a></li>
				<li class="nav-item">
					<%
					if (loggedInAdminname != "Admin") {
					%> <a class="nav-link" href="view.jsp">Pets</a> <%
 } else {
 %> <a class="nav-link" href="addCart.jsp">Pets</a> <%
 }
 %>
				</li>
				<%
				if (loggedInAdminname != "Admin") {
				%>
				
				<li class="nav-item dropdown">
					<div class="dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="dropdownId"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Search
							By Cost</a>
						<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
							<a class="dropdown-item" href="SearchByCostServlet?cost=1">Below
								10000</a> <a class="dropdown-item" href="SearchByCostServlet?cost=2">Below
								15000</a> <a class="dropdown-item" href="SearchByCostServlet?cost=3">Below
								25000</a> <a class="dropdown-item" href="SearchByCostServlet?cost=4">Above
								25000</a>
						</div>
					</div>
				</li>
				<%
				}
				%>
			</ul>
			<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
				<%
				if (loggedInUsername == null) {
				%>
				<li class="nav-item active"><a class="nav-link"
					href="adminLogin.jsp">Admin</a></li>
				<li class="nav-item"><a class="nav-link" href="userLogin.jsp">User</a>
				</li>
				<%
				} else {
				%>
				<li class="nav-item"><a class="nav-link" href="#">Welcome <%=loggedInUsername%></a>
				</li>
				<li class="nav-item"><a class="nav-link" href="LogoutServlet"
					method="get">Logout</a></li>
				<%
				}
				%>
			</ul>
		</div>
	</nav>
</header>