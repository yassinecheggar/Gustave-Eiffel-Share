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
	Vector<Produit> produits = (Vector<Produit>) request.getAttribute("produit");
%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Gustave Eiffel | Dashboard</title>
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font Awesome -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

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
				<%  if(u.getUserType() == 1){ %>
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
				<%}else { %>
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
								
								<li class="nav-item"><a href="/Web/Emprunt/ListeH"
									class="nav-link"> <i class="fas fa-history nav-icon"></i>
										<p>Historique</p>
								</a></li>
								
								<li class="nav-item"><a href="/Web/Produit/Restituer"
									class="nav-link"> <i class="fas fa-undo-alt nav-icon"></i>
										<p>Restituer</p>
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
								
								<li class="nav-item"><a href="/Web/Produit/EditePu"
									class="nav-link"> <i class="fas fa-edit nav-icon"></i>
										<p>Modifier</p>
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

								
								
									<li class="nav-item"><a href="/Web/User/loginP"
									class="nav-link"> <i class="fas fa-sign-out-alt nav-icon"></i>
										<p>Logout</p>
								</a></li>
								

							</ul></li>
				
				</ul>
				</nav>
		<%} %>		
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

			<script type="text/javascript">
				function setAction(element ,id) {
					var a = document.getElementById("myform");
					
					var ff= document.getElementById("kk")
					ff.value = id;
					
					a.action = element;
					a.submit();
				}
				
				function restituer(id) {
					var a = document.getElementById("mform");
					var ff= document.getElementById("xx")
					ff.value = id;
				}
				
				
				
			</script>



			<!-- Main content -->
			<section class="content">
				<div class="row align-items-center">
				<form action="" id="myform">
					<input type="hidden" value="1" name="lola" id="kk">
					</form>
					<div class="card-deck">
						<%
							int i = 0;
							int a = produits.size();
							boolean cl = true;
							String row;
							String close;
							for (Produit c : produits) {
								close = "";
								row = "";
								if ((i % 4) == 0) {
									if (i > 0) {
										close = "</div> </div>";
										row = "<div class=\"row\">  <div class=\"card-deck\">";
									}
								}
						%>
						<%=close%>
						<%=row%>
						<div class="card" style="width: 18rem;">
							<img class="card-img-top imgg"
								src="../data/<%=c.getImagepath()%>" alt="Card image cap">
							<div class="card-body ">
								<h5 class="card-title"><%=c.getDesig()%></h5>
								<p class="card-text">
									<%=c.getCommentaire()%></p>

								
									
									<% 
										String emp = "";
										String res="disabled";
											if (c.getStatut().equals("Indisponible")) {
												emp = "disabled";
												res="";	}
									%>
									<Button data-toggle="modal" data-target="#exampleModal" data-whatever="@getbootstrap"  class="btn btn-primary " onclick='restituer("<%=c.getId() %>");'>Restituer</button>
									
									<button class="btn btn-info pull-down " onclick='setAction("../Produit/InfoProduit","<%=c.getId() %>");' >Info</button>

								

							</div>
						</div>
						<%
							i++;
						%>

						<%
							}
						%>
					</div>
	
				</div>
	<script>
function add(ths,sno){


for (var i=1;i<=5;i++){
var cur=document.getElementById("star"+i)
cur.className="fa fa-star"
}

for (var i=1;i<=sno;i++){
var cur=document.getElementById("star"+i)
if(cur.className=="fa fa-star")
{
cur.className="fa fa-star checked"
}
}
document.getElementById("nti").value=sno;

}
</script>			
				
				<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Restituer</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form id="mform" action="../Produit/Restitu">
        <input type="hidden" id="xx" name="idpr" >
         <input type="hidden" id="nti" name="nt" >
          <div class="form-group">
          
            <label for="recipient-name" class="col-form-label">Note</label>
           <div class="container">
	<style>
.checked {
    color: orange;
}
</style>




  <span class="fa fa-star" id="star1" onclick="add(this,1)"></span>
  <span class="fa fa-star" id="star2" onclick="add(this,2)"></span>
  <span class="fa fa-star" id="star3" onclick="add(this,3)"></span>
  <span class="fa fa-star" id="star4" onclick="add(this,4)"></span>
  <span class="fa fa-star" id="star5" onclick="add(this,5)"></span>


</div>
          </div>
          <div class="form-group">
            <label for="message-text" class="col-form-label">Commentaire:</label>
            <textarea class="form-control" id="message-text" name="comment"></textarea>
          </div>
          <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Restituer</button>
      </div>
        </form>
          
      </div>
    
    </div>
  </div>
</div>
				
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
