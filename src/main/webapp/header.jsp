<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet" href=" bootstrap.js">
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
<header>
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<a class="navbar-brand" href="#">Online Pets App</a>
		<button class="navbar-toggler d-lg-none" type="button"
			data-toggle="collapse" data-target="#collapsibleNavId"
			aria-controls="collapsibleNavId" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavId">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link"
					href="index.jsp">HOME <span class="sr-only">(current)</span></a></li>
				<li class="nav-item">
					<%
					if (loggedInAdminname != "Admin")
					{
						%> <a class="nav-link"
						href="View.jsp">Pets</a> <%
					}
					else
					{
 						%> <a class="nav-link" href="AddCart.jsp">Pets</a> <%
 					}
 					%>
				</li>
				<%
				if (loggedInAdminname != "Admin") {
				%>
				<li class="nav-item dropdown">
					<div class="dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="dropdownId"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Cost</a>
						<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
							<a class="dropdown-item" href="SearchByCostServlet?cost=1">Below
								10000</a> <a class="dropdown-item" href="SearchByCostServlet?cost=2">above
								10000</a>
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
					href="AdminLogin.jsp">Admin</a></li>
				<li class="nav-item"><a class="nav-link" href="UserLogin.jsp">User</a>
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