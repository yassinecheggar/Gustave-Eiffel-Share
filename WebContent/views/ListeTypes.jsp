<%@page import="com.upem.models.UserType"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.upem.models.Categorie"%>
<%@page import="com.upem.models.Produit"%>
<%@page import="java.util.Vector"%>
<%@page import="com.upem.models.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<% User u = (User)request.getAttribute("user");
Vector<UserType>vec = (Vector<UserType>)request.getAttribute("type");
%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>AdminLTE 3 | General Form Elements</title>
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Font Awesome -->
<link rel="stylesheet"
	href="../AdminLTE-master/plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="../AdminLTE-master/plugins/datatables-bs4/css/dataTables.bootstrap4.css">
<link rel="stylesheet"
	href="../AdminLTE-master/dist/css/adminlte.min.css">
<!-- Google Font: Source Sans Pro -->
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"
	rel="stylesheet">
</head>
<body class="hold-transition sidebar-mini">
	<div class="wrapper">
		<!-- Navbar -->
		<nav
			class="main-header navbar navbar-expand navbar-white navbar-light">
			<!-- Left navbar links -->
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" data-widget="pushmenu"
					href="#"><i class="fas fa-bars"></i></a></li>
				<li class="nav-item d-none d-sm-inline-block"><a
					href="/Web/Produit/home" class="nav-link">Home</a></li>
				<li class="nav-item d-none d-sm-inline-block"><a href="#"
					class="nav-link">Contact</a></li>
			</ul>

			<!-- SEARCH FORM -->


			<!-- Right navbar links -->
			<ul class="navbar-nav ml-auto">
				<!-- Messages Dropdown Menu -->

				<!-- Notifications Dropdown Menu -->
				<li class="nav-item dropdown"><a class="nav-link"
					data-toggle="dropdown" href="#"> <i class="far fa-bell"></i> <span
						class="badge badge-warning navbar-badge">15</span>
				</a>
					<div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
						<span class="dropdown-item dropdown-header">15
							Notifications</span>
						<div class="dropdown-divider"></div>
						<a href="#" class="dropdown-item"> <i
							class="fas fa-envelope mr-2"></i> 4 new messages <span
							class="float-right text-muted text-sm">3 mins</span>
						</a>
						<div class="dropdown-divider"></div>
						<a href="#" class="dropdown-item"> <i
							class="fas fa-users mr-2"></i> 8 friend requests <span
							class="float-right text-muted text-sm">12 hours</span>
						</a>
						<div class="dropdown-divider"></div>
						<a href="#" class="dropdown-item"> <i class="fas fa-file mr-2"></i>
							3 new reports <span class="float-right text-muted text-sm">2
								days</span>
						</a>
						<div class="dropdown-divider"></div>
						<a href="#" class="dropdown-item dropdown-footer">See All
							Notifications</a>
					</div></li>
				<li class="nav-item"><a class="nav-link"
					data-widget="control-sidebar" data-slide="true" href="#"> <i
						class="fas fa-th-large"></i>
				</a></li>
			</ul>
		</nav>
		<!-- /.navbar -->

		<!-- Main Sidebar Container -->
		<aside class="main-sidebar sidebar-dark-primary elevation-4">
			<!-- Brand Logo -->
			<a href="index3.html" class="brand-link"> <img
				src="../AdminLTE-master/dist/img/AdminLTELogo.png"
				alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
				style="opacity: .8"> <span
				class="brand-text font-weight-light">Gustave Eiffel</span>
			</a>

			<!-- Sidebar -->
			<div class="sidebar">
				<!-- Sidebar user panel (optional) -->
				<div class="user-panel mt-3 pb-3 mb-3 d-flex">
					<div class="image">
						<img src="https://i.ibb.co/RbyFXL9/Canon-EOS-REBEL-T3i151.jpg"
							class="img-circle elevation-2" alt="User Image">
					</div>
					<div class="info">
						<a href="#" class="d-block"><%=u.getPrenom() +" "+u.getNom() %></a>
					</div>
				</div>

				<!-- Sidebar Menu -->
				<nav class="mt-2">
					<ul class="nav nav-pills nav-sidebar flex-column"
						data-widget="treeview" role="menu" data-accordion="false">
						<!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
						<li class="nav-item has-treeview"><a href="#"
							class="nav-link active"> <i class="nav-icon fab fa-empire"></i>
								<p>
									Emprunt <i class="right fas fa-angle-left"></i>
								</p>
						</a>
							<ul class="nav nav-treeview">
								<li class="nav-item"><a href="./index.html"
									class="nav-link "> <i class="fas fa-align-justify nav-icon"></i>
										<p>Liste Emprunt</p>
								</a></li>
								<li class="nav-item"><a href="./index2.html"
									class="nav-link"> <i class="fas fa-user-plus nav-icon"></i>
										<p>Ajouter</p>
								</a></li>


								<li class="nav-item"><a href="./index3.html"
									class="nav-link"> <i class="fas fa-edit nav-icon"></i>
										<p>Modifier</p>
								</a></li>

								<li class="nav-item"><a href="./index3.html"
									class="nav-link"> <i class="far fa-trash-alt nav-icon"></i>
										<p>Supprimer</p>
								</a></li>
							</ul></li>

						<li class="nav-item has-treeview"><a href="#"
							class="nav-link"> <i class="nav-icon fab fa-empire"></i>
								<p>
									Produit <i class="fas fa-angle-left right"></i>

								</p>
						</a>
							<ul class="nav nav-treeview">


								<li class="nav-item"><a href="/Web/Produit/ListeP"
									class="nav-link"> <i class="fas fa-align-justify nav-icon"></i>
										<p>Liste Produit</p>
								</a></li>
								<li class="nav-item"><a href="/Web/Produit/AddP"
									class="nav-link"> <i class="fas fa-user-plus nav-icon"></i>
										<p>Ajouter</p>
								</a></li>
								<li class="nav-item"><a href="/Web/Produit/EditeP"
									class="nav-link"> <i class="fas fa-edit nav-icon"></i>
										<p>Modifier</p>
								</a></li>
								<li class="nav-item"><a href="/Web/Produit/deleteP"
									class="nav-link"> <i class="far fa-trash-alt nav-icon"></i>
										<p>Suprimer</p>
								</a></li>

							</ul></li>

						<li class="nav-item has-treeview"><a href="#"
							class="nav-link"> <i class="nav-icon fab fa-empire"></i>
								<p>
									Utilisateur <i class="fas fa-angle-left right"></i>

								</p>
						</a>
							<ul class="nav nav-treeview">


								<li class="nav-item"><a href="/Web/User/ListeU"
									class="nav-link"> <i class="fas fa-align-justify nav-icon"></i>
										<p>Lister</p>
								</a></li>

								<li class="nav-item"><a href="/Web/Produit/EditeP"
									class="nav-link"> <i class="fas fa-edit nav-icon"></i>
										<p>Modifier</p>
								</a></li>
								<li class="nav-item"><a href="/Web/User/deleteU"
									class="nav-link"> <i class="far fa-trash-alt nav-icon"></i>
										<p>Suprimer</p>
								</a></li>

							</ul></li>



						<li class="nav-item has-treeview"><a href="#"
							class="nav-link"> <i class="nav-icon fab fa-empire"></i>
								<p>
									Type Utilisateur <i class="fas fa-angle-left right"></i>

								</p>
						</a>
							<ul class="nav nav-treeview">


								<li class="nav-item"><a href="/Web/UserT/ListT"
									class="nav-link"> <i class="fas fa-align-justify nav-icon"></i>
										<p>Lister</p>
								</a></li>
								<li class="nav-item"><a href="/Web/UserT/AddU"
									class="nav-link"> <i class="fas fa-user-plus nav-icon"></i>
										<p>Ajouter</p>
								</a></li>
								<li class="nav-item"><a href="/Web/UserT/EditT"
									class="nav-link"> <i class="fas fa-edit nav-icon"></i>
										<p>Modifier</p>
								</a></li>
								<li class="nav-item"><a href="/Web/UserT/deleteT"
									class="nav-link"> <i class="far fa-trash-alt nav-icon"></i>
										<p>Suprimer</p>
								</a></li>

							</ul></li>



						<li class="nav-item has-treeview"><a href="#"
							class="nav-link"> <i class="nav-icon fab fa-empire"></i>
								<p>
									Categorie Produit <i class="fas fa-angle-left right"></i>

								</p>
						</a>
							<ul class="nav nav-treeview">


								<li class="nav-item"><a href="/Web/Categorie/ListC"
									class="nav-link"> <i class="fas fa-align-justify nav-icon"></i>
										<p>Lister</p>
								</a></li>
								<li class="nav-item"><a href="/Web/Categorie/AddC"
									class="nav-link"> <i class="fas fa-user-plus nav-icon"></i>
										<p>Ajouter</p>
								</a></li>
								<li class="nav-item"><a href="/Web/Categorie/EditC"
									class="nav-link"> <i class="fas fa-edit nav-icon"></i>
										<p>Modifier</p>
								</a></li>
								<li class="nav-item"><a href="/Web/Categorie/deleteC"
									class="nav-link"> <i class="far fa-trash-alt nav-icon"></i>
										<p>Suprimer</p>
								</a></li>

							</ul></li>







					</ul>
				</nav>
				<!-- /.sidebar-menu -->
			</div>
			<!-- /.sidebar -->
		</aside>


		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container-fluid">
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- /.content-header -->

			<!-- Main content---------------------------------------------------------------------------------------------------- -->

			<div class="card">
				<div class="card-header">
					<h3 class="card-title">Liste Type utilisateur</h3>
				</div>
				<!-- /.card-header -->
				<div class="card-body">
					<table id="example1" class="table table-bordered table-striped">
						<thead>
							<tr>
								 <th>ID</th>
                      <th>Type</th>    
							</tr>
						</thead>
							<tbody>
                  <% 
                	  for(UserType c : vec){   	  
                  %>
                    <tr>
                      <td><%= c.getUserTypeId() %></td>
                      <td><%= c.getType() %></td>
                      
                    </tr>
                    <% } %>
                   
                   
                  </tbody>
					</table>
				</div>
				<!-- /.card-body -->
			</div>

			<!-- /.content------------------------------------------------------------------------------------------------------------ -->

			<!-- /.content-wrapper -->


			<!-- Control Sidebar -->
			<aside class="control-sidebar control-sidebar-dark">
				<!-- Control sidebar content goes here -->
			</aside>
			<!-- /.control-sidebar -->
		</div>
		<!-- ./wrapper -->

		<!-- jQuery -->
		<script src="../AdminLTE-master/plugins/jquery/jquery.min.js"></script>
		<!-- Bootstrap 4 -->
		<script
			src="../AdminLTE-master/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
		<!-- bs-custom-file-input -->
		<script
			src="../AdminLTE-master/plugins/bs-custom-file-input/bs-custom-file-input.min.js"></script>
		<!-- DataTables -->
		<script
			src="../AdminLTE-master/plugins/datatables/jquery.dataTables.js"></script>
		<script
			src="../AdminLTE-master/plugins/datatables-bs4/js/dataTables.bootstrap4.js"></script>
		<!-- AdminLTE App -->
		<script src="../AdminLTE-master/dist/js/adminlte.min.js"></script>
		<!-- AdminLTE for demo purposes -->
		<script src="../AdminLTE-master/dist/js/demo.js"></script>
		<script type="text/javascript">
$(document).ready(function () {
  bsCustomFileInput.init();
});
</script>

		<script>
  $(function () {
    $("#example1").DataTable();
    $('#example2').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": false,
      "ordering": true,
      "info": true,
      "autoWidth": false,
    });
  });
</script>
</body>
</html>

