<%@page import="com.upem.models.Commentaire"%>
<%@page import="com.upem.models.Produit"%>
<%@page import="java.util.Vector"%>
<%@page import="com.upem.models.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%
	User u = (User) request.getAttribute("user");
	Produit produits = (Produit) request.getAttribute("produit");
	Vector<Commentaire>comm = (Vector<Commentaire>)request.getAttribute("com");
	Vector<User>use = (Vector<User>)request.getAttribute("use");
%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Gustave Eiffel | Dashboard</title>
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="../AdminLTE-master/plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- Tempusdominus Bbootstrap 4 -->
<link rel="stylesheet"
	href="../AdminLTE-master/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
<!-- iCheck -->
<link rel="stylesheet"
	href="../AdminLTE-master/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
<!-- JQVMap -->
<link rel="stylesheet"
	href="../AdminLTE-master/plugins/jqvmap/jqvmap.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="../AdminLTE-master/dist/css/adminlte.min.css">
<!-- overlayScrollbars -->
<link rel="stylesheet"
	href="../AdminLTE-master/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
<!-- Daterange picker -->
<link rel="stylesheet"
	href="../AdminLTE-master/plugins/daterangepicker/daterangepicker.css">
<!-- summernote -->
<link rel="stylesheet"
	href="../AdminLTE-master/plugins/summernote/summernote-bs4.css">
<!-- mycss -->
<link rel="stylesheet" href="../AdminLTE-master/mycss.css">

<!-- Google Font: Source Sans Pro -->
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"
	rel="stylesheet">
</head>
<body class="hold-transition sidebar-mini layout-fixed">
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
						class="badge badge-warning navbar-badge"></span>
				</a></li>
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
						<a href="#" class="d-block"><%=u.getPrenom() + " " + u.getNom()%></a>
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
					<div class="row mb-2">
						<div class="col-sm-6">
						</div>
						<!-- /.col -->
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								
								
							</ol>
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- /.content-header -->

			<script type="text/javascript">
				function setAction(element ,id) {
					var a = document.getElementById("myform");
					
					var ff= document.getElementById("kk")
					ff.value = id;
					
					a.action = element;
					a.submit();
				}
			</script>



			<!-- Main content -->
		<section class="content">
      
      <div class="card">
        <div class="row">
          <aside class="col-sm-5 border-right">
      <article class="gallery-wrap mx-auto text-center"> 
        
          <img src="../data/<%=produits.getImagepath() %>" style="width: 18rem;">
     
        
      
      </article> <!-- gallery-wrap .end// -->
          </aside>
          <aside class="col-sm-7">
      <article class="card-body p-5">
        <h3 class="title mb-3"><%=produits.getDesig() %></h3>
      
      <p class="price-detail-wrap"> 
        <span class="price h3 text-warning"> 
          <span class="currency">euro </span><span class="num"><%=produits.getPrix() %></span>
        </span> 
        
      </p> <!-- price-detail-wrap .// -->
      <dl class="item-property">
        <dt>Description</dt>
        <dd><p> <%=produits.getCommentaire() %> </p></dd>
      </dl>
       <!-- item-property-hor .// -->
      <dl class="param param-feature">
        <dt>Etat</dt>
        <dd><%=produits.getEtat() %></dd>
      </dl>  <!-- item-property-hor .// -->
      <dl class="param param-feature">
        <dt>Proprietaire</dt>
        <% for(User usr : use){ 
                                	if(usr.getIdUser()==produits.getIdUser()){
                                	%>
        <dd><%=usr.getNom() +" "+ usr.getPrenom() %></dd>
      </dl>  <!-- item-property-hor .// -->
      <%}} %>
        <!-- row.// -->
        
      </article> <!-- card-body.// -->
          </aside> <!-- col.// -->
        </div> <!-- row.// -->
      </div>


      <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

      <div class="container">
        <h2 class="text-center">Commentaires </h2>
        
        <% for(Commentaire cm : comm){ %>
        <div class="card">
            <div class="card-body">
                <div class="row">
                    <div class="col-md-2">
                        <img src="https://image.ibb.co/jw55Ex/def_face.jpg" class="img img-rounded img-fluid"/>
                        
                    </div>
                    <div class="col-md-10">
                    
                        <p>
                                <% for(User usr : use){ 
                                	if(usr.getIdUser()==cm.getIdUser()){
                                	%>
                               
                        
                            <a class="float-left" href="https://maniruzzaman-akash.blogspot.com/p/contact.html"><strong><%=usr.getNom() + " " +usr.getPrenom() %></strong></a> <%} } %>
                            <% for(int i=0; i<cm.getRate();i++){ %>
                            <span class="float-right"><i class="text-warning fa fa-star"></i></span>
                            
                           
      <%} %>
                       </p>
                       <div class="clearfix"></div>
                        <p><%=cm.getComment() %></p>
                        
                    </div>
                </div>
                  
            </div>
           
        </div><%} %>
      <!-- /.container-fluid -->
    </section>
			<!-- right col -->
		</div>
		<!-- /.row (main row) -->
	</div>
	<!-- /.container-fluid -->
	</section>
	<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->
	<footer class="main-footer">
		<strong>Copyright &copy; 2019-2020 <a href="#">Cheggar
				w124 </a>.
		</strong> All rights reserved.
		<div class="float-right d-none d-sm-inline-block">
			<b>Version</b> 3.0.2-pre
		</div>
	</footer>

	<!-- Control Sidebar -->
	<aside class="control-sidebar control-sidebar-dark">
		<!-- Control sidebar content goes here -->
	</aside>
	<!-- /.control-sidebar -->
	</div>
	<!-- ./wrapper -->

	<!-- jQuery -->
	<script src="../AdminLTE-master/plugins/jquery/jquery.min.js"></script>
	<!-- jQuery UI 1.11.4 -->
	<script src="../AdminLTE-master/plugins/jquery-ui/jquery-ui.min.js"></script>
	<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
	<script>
		$.widget.bridge('uibutton', $.ui.button)
	</script>
	<!-- Bootstrap 4 -->
	<script
		src="../AdminLTE-master/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- ChartJS -->
	<script src="../AdminLTE-master/plugins/chart.js/Chart.min.js"></script>
	<!-- Sparkline -->
	<script src="../AdminLTE-master/plugins/sparklines/sparkline.js"></script>
	<!-- JQVMap -->
	<script src="../AdminLTE-master/plugins/jqvmap/jquery.vmap.min.js"></script>
	<script src="../AdminLTE-master/plugins/jqvmap/maps/jquery.vmap.usa.js"></script>
	<!-- jQuery Knob Chart -->
	<script src="../AdminLTE-master/plugins/jquery-knob/jquery.knob.min.js"></script>
	<!-- daterangepicker -->
	<script src="../AdminLTE-master/plugins/moment/moment.min.js"></script>
	<script
		src="../AdminLTE-master/plugins/daterangepicker/daterangepicker.js"></script>
	<!-- Tempusdominus Bootstrap 4 -->
	<script
		src="../AdminLTE-master/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
	<!-- Summernote -->
	<script
		src="../AdminLTE-master/plugins/summernote/summernote-bs4.min.js"></script>
	<!-- overlayScrollbars -->
	<script
		src="../AdminLTE-master/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
	<!-- AdminLTE App -->
	<script src="../AdminLTE-master/dist/js/adminlte.js"></script>
	<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
	<script src="../AdminLTE-master/dist/js/pages/dashboard.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="../AdminLTE-master/dist/js/demo.js"></script>
</body>
</html>
