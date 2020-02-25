
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">

<head>
<spring:url value="https://augustobrigadaw.000webhostapp.com/resources2"
	var="urlPublic"></spring:url>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Fruteria para el cliente</title>

<!-- Bootstrap core CSS -->
<link href="${urlPublic}/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${urlPublic}/css/shop-homepage.css" rel="stylesheet">

</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="#">Fruteria Online</a>
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
					<li class="nav-item"><a class="nav-link" href="#">About</a></li>
					<li class="nav-item"><a class="nav-link" href="#">${user.nombre }</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="login">Login</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Page Content -->
	<div class="container">

		<div class="row">

			<div class="col-lg-3">

				<h1 class="my-4">LupoXan</h1>
				<div class="list-group">
					<a href="home" class="list-group-item">Todo</a>
					<a href="categorias?categoria=Fruta" class="list-group-item">Frutas</a>
					<a href="categorias?categoria=Legumbre" class="list-group-item">Legumbres</a>
					<a href="categorias?categoria=Hortaliza" class="list-group-item">Hortalizas</a>
				</div>

			</div>
			<!-- /.col-lg-3 -->

			<div class="col-lg-9">

				<div id="carouselExampleIndicators" class="carousel slide my-4"
					data-ride="carousel" data-interval = "5000">
					<ol class="carousel-indicators">
						<c:forEach items="${slides}" var="slide" varStatus="status">
							<c:if test="${status.index == 0 }">
								<li data-target="#carouselExampleIndicators"
									data-slide-to="${status.index }" class="active"></li>
							</c:if>
							<c:if test="${status.index != 0 }">
								<li data-target="#carouselExampleIndicators"
									data-slide-to="${status.index}"></li>
							</c:if>
						</c:forEach>
					</ol>
					<div class="carousel-inner" role="listbox">
						<c:forEach items="${slides}" var="slide" varStatus="status">
							<c:if test="${status.index == 0 }">
								<div class="carousel-item active">
									<img class="d-block img-fluid" src="${slide.imagen}" alt="Slide"
										title="${status.index }">
								</div>
							</c:if>
							<c:if test="${status.index != 0 }">
								<div class="carousel-item">
									<img class="d-block img-fluid" src="${slide.imagen}" alt="Slide"
										title="${status.index }">
								</div>
							</c:if>
						</c:forEach>

					</div>
					<a class="carousel-control-prev" href="#carouselExampleIndicators"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" aria-hidden="true"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
						role="button" data-slide="next"> <span
						class="carousel-control-next-icon" aria-hidden="true"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>

				<div class="row">
					<c:forEach items="${frutas }" var="fruta">
						<div class="col-lg-4 col-md-6 mb-4">
							<div class="card h-100">
								<a href="carrito/${fruta.id }"><img width = 100 height = 100 class="card-img-top"
									src="${urlPublic }/img/${fruta.imagen }" alt=""></a>
								<div class="card-body">
									<h4 class="card-title">
										<a href="carrito/${fruta.id }">${fruta.nombre }</a>
									</h4>
									<h5>$ ${fruta.precio }</h5>
									<p class="card-text">${fruta.categoria }</p>
									<p class="card-text">${fruta.procedencia }</p>
								</div>
								<div class="card-footer">
									<small class="text-muted">&#9733; &#9733; &#9733;
										&#9733; &#9734;</small>
								</div>
							</div>
						</div>
					</c:forEach>
					
				</div>
				<!-- /.row -->

			</div>
			<!-- /.col-lg-9 -->

		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

	<!-- Footer -->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Fruteria Lupo Xan 2019</p>
		</div>
		<!-- /.container -->
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="${urlPublic}/vendor/jquery/jquery.min.js"></script>
	<script src="${urlPublic}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>