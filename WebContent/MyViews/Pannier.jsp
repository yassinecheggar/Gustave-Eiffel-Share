<%@page import="com.upem.models.Commentaire"%>
<%@page import="com.upem.models.Produit"%>
<%@page import="com.upem.models.Pannier"%>
<%@page import="com.upem.models.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<%
	User u = (User) request.getAttribute("user");
	Pannier[] pan = (Pannier[]) request.getAttribute("pannier");
	Produit[] produit = (Produit[]) request.getAttribute("produit");

	Commentaire[] com = (Commentaire[]) request.getAttribute("comment");
	int i = 0;
	if (pan != null) {
		i = pan.length;
	}
%>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Shop Item - Start Bootstrap Template</title>

<!-- Bootstrap core CSS -->
<link href="../bootstrap/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
	
	<link href="../bootstrap/mycss.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../bootstrap/css/shop-item.css" rel="stylesheet">
<link rel="stylesheet"
	href="../AdminLTE-master/plugins/fontawesome-free/css/all.min.css">

</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="#">Gustave Eiffel</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link" href="#">Home
							<span class="sr-only">(current)</span>
					</a></li>



					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" id="navbarDropdownMenuLink-4"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							<i class="fas fa-user"></i> <%=u.getNom() + " " + u.getPrenom()%>
					</a>
						<div class="dropdown-menu dropdown-menu-right dropdown-info"
							aria-labelledby="navbarDropdownMenuLink-4">

							<a class="dropdown-item" href="#">Log out</a>
						</div></li>

					<li class="nav-item"><a class="nav-link" href="#"> <i
							class="fas fa-shopping-cart"></i> <span
							class="badge badge-warning navbar-badge"><%=i%></span>
					</a></li>

				</ul>
			</div>
		</div>
	</nav>

	<!-- Page Content -->
	<div class="container">
		
		<div class="card" style="margin-top: 100px;">
			<table class="table table-hover shopping-cart-wrap">
				<thead class="text-muted">
					<tr>
						<th scope="col">Product</th>
						
						<th scope="col" width="120">Price</th>
						<th scope="col" width="200" class="text-right">Action</th>
					</tr>
				</thead>
				<tbody>
				
					<%if (pan != null) { 
				for(Pannier pann: pan){
					%>
						<tr>
						<%for(Produit prod :produit){
									
									if(prod.getId()==pann.getIdProduit()){
										
									
									%>
						<td>
							<figure class="media">
								<div class="img-wrap">
									<img
										src="../data/<%=prod.getImagepath() %>"
										class="img-thumbnail img-sm">
								</div>
								<figcaption class="media-body">
								
								
									<h6 class="title text-truncate"><%=prod.getDesig()%></h6>
									
									
									<dl class="param param-inline small">
										
									</dl>
									<dl class="param param-inline small">
										
									</dl>
								</figcaption>
							</figure>
						</td>
						
						<td>
							<div class="price-wrap">
								<var class="price"><%=prod.getPrix() %> EU</var>
								<small class="text-muted"></small><%} }%>
							</div> <!-- price-wrap .// -->
						</td>
						<td class="text-right"> <a href=""
							class="btn btn-outline-danger"> × Remove</a></td>
					</tr>
					<%}} %>
					
					
				</tbody>
			</table>
		</div>
		<!-- card.// -->

	</div>
	<!-- /.container -->

	<!-- Footer -->
	<footer class="fixed-bottom bg-dark ">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2019</p>
		</div>
		<!-- /.container -->
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="../bootstrap/vendor/jquery/jquery.min.js"></script>
	<script src="../bootstrap/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="../AdminLTE-master/plugins/jquery/jquery.min.js"></script>

</body>

</html>
