<%@page import="com.upem.models.Pannier"%>
<%@page import="com.upem.models.User"%>
<%@page import="com.upem.models.Produit"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<% User u = (User)request.getAttribute("user");
	Pannier[] pan = (Pannier[])request.getAttribute("pannier");
	int i=0;
	if(pan != null){
		i = pan.length;
	}
%>
<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Shop Homepage - Start Bootstrap Template</title>

  <!-- Bootstrap core CSS -->
  <link href="../bootstrap/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="../AdminLTE-master/plugins/fontawesome-free/css/all.min.css">
  <!-- Custom styles for this template -->
  <link href="../bootstrap/css/shop-homepage.css" rel="stylesheet">

</head>

<body>

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="#">Gustave Eiffel</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="#">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          
        
         
         <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink-4" data-toggle="dropdown"
          aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-user"></i> <%=u.getNom()+" "+ u.getPrenom() %> </a>
        <div class="dropdown-menu dropdown-menu-right dropdown-info" aria-labelledby="navbarDropdownMenuLink-4">
          
          <a class="dropdown-item" href="#">Log out</a>
        </div>
        
      </li>
      
      <li class="nav-item">
            <a class="nav-link"  href="#">
          <i class="fas fa-shopping-cart"></i> 
          <span class="badge badge-warning navbar-badge"><%=i%></span>
        </a>
          </li>
        
        </ul>
      </div>
    </div>
  </nav>

<script type="text/javascript">
				function myconf(id) {
					var a = document.getElementById("myform");
					var ff= document.getElementById("kk")
					ff.value =id;
					a.action = "../EProduit/Produit";
					a.submit();
				}
				
				
				function myconf2(id) {
					var a = document.getElementById("myform");
					var ff= document.getElementById("kk")
					ff.value =id;
					a.action = "../EProduit/addPanier";
					a.submit();
				}
				
				
			</script>	

  <!-- Page Content -->
  <div class="container">

    <div class="row">

      <div class="col-lg-3">

        <h1 class="my-4">UGESellService</h1>
        <div class="list-group">
          <a href="#" class="list-group-item">Category 1</a>
          <a href="#" class="list-group-item">Logout</a>
          
        </div>

      </div>
      <!-- /.col-lg-3 -->

      <div class="col-lg-9">

        <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
          <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
          </ol>
          <div class="carousel-inner" role="listbox">
            <div class="carousel-item active">
              <img class="d-block img-fluid" src="https://webcomicms.net/sites/default/files/clipart/129784/bowling-images-129784-9912981.jpg" alt="First slide">
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid" src="../data/page-speed-900x350.jpg" alt="Second slide">
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid" src="../data/DZN-Blog-Hero-900x350-5KPIs.jpg" alt="Third slide">
            </div>
          </div>
          <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>

        <div class="row">
<% Produit Pro[]= (Produit[]) request.getAttribute("Pro");

for(Produit p : Pro){
	%>

          <div class="col-lg-4 col-md-6 mb-4">
            <div class="card h-100">
              <a href="javascript:myconf(<%=p.getId() %>);"><img class="card-img-top" src="../data/<%=p.getImagepath() %>"  style="height: 300px"></a>
              <div class="card-body">
                <h4 class="card-title">
                  <a href="javascript:myconf(<%=p.getId() %>)" ><%=p.getDesig() %></a>
                </h4>
                <h5>$<%=p.getPrix() %></h5>
                <p class="card-text"><%=p.getCommentaire()%></p>
              </div>
              <div class="card-footer col text-center">
              
              <button class="btn btn-success" onclick="myconf2(<%=p.getId() %>)"><i class="fas fa-shopping-cart"></i> Ajouter</button>
               
              </div>
            </div>
          </div>

          <%} %>

     

        </div>
        <!-- /.row -->
		<form id="myform" >
			<input type="hidden" id="kk" name="id">
		</form>
      </div>
      <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->

  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; Your Website 2019</p>
    </div>
    <!-- /.container -->
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="../bootstrap/vendor/jquery/jquery.min.js"></script>
  <script src="../bootstrap/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="../AdminLTE-master/plugins/jquery/jquery.min.js"></script>
</body>

</html>
