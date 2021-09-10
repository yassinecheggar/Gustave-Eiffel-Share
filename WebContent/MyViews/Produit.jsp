<%@page import="com.upem.models.Commentaire"%>
<%@page import="com.upem.models.Produit"%>
<%@page import="com.upem.models.Pannier"%>
<%@page import="com.upem.models.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<% User u = (User)request.getAttribute("user");
Pannier[] pan = (Pannier[])request.getAttribute("pannier");
Produit Pro = (Produit)request.getAttribute("Pro");
Commentaire[] com =  (Commentaire[])request.getAttribute("comment");
int i=0;
if(pan != null){
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
							<i class="fas fa-user"></i> <%=u.getNom()+" "+ u.getPrenom() %>
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
	<div class="container" style="margin-top: 40px">

		<div class="row">

			<div class="col-lg-3">
				<h1 class="my-4">Shop Name</h1>
				<div class="list-group">
					<a href="#" class="list-group-item active">Category 1</a> <a
						href="#" class="list-group-item">Category 2</a> <a href="#"
						class="list-group-item">Category 3</a>
				</div>
			</div>
			<!-- /.col-lg-3 -->

			<div class="col-lg-9">

				<div class="card mt-4">
				<div class="text-center">
					<img class="card-img-top  "
						src="../data/<%=Pro.getImagepath() %>"style="width: 400px; height: auto;"> </div>
					<div class="card-body">
						<h3 class="card-title"><%=Pro.getDesig() %></h3>
						<h4>$<%=Pro.getPrix() %></h4>
						<p class="card-text"><%=Pro.getDesig() %></p>
						
					</div>
				</div>
				<!-- /.card -->

				<div class="card card-outline-secondary my-4">
					<div class="card-header">Product Reviews</div>
				
					<div class="card-body">
					
				<% if(com !=null){ 
				for(Commentaire Co : com){ %>
					
					<p><%=Co.getComment()%></p>
					<small class="text-muted">Posted by Anonymous on 3/1/17</small>
						<hr>
						<%} }%>
						
						
						<a href="#" class="btn btn-success">Leave a Review</a>
					</div>
				</div>
				<!-- /.card -->

			</div>
			<!-- /.col-lg-9 -->

		</div>

	</div>
	<!-- /.container -->

	<!-- Footer -->
	<footer class="py-5 bg-dark">
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
