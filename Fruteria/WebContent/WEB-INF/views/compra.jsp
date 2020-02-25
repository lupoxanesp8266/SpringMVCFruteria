<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Carro de la compra</title>
<spring:url value="https://augustobrigadaw.000webhostapp.com/resources2"
	var="urlPublic"></spring:url>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="col-md-6">
				<h4 class="text-center">Lista de la compra</h4>
				<hr>
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>Id</th>
							<th>Nombre</th>
							<th>categoria</th>
							<th>Imagen</th>
							<th>Procedencia</th>
							<th>Precio</th>
							<th>Eliminar</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${carro}" var="fruta">
							<tr>
								<td>${fruta.id}</td>
								<td>${fruta.nombre }</td>
								<td>${fruta.categoria }</td>
								<td><img width="100" height="100"
									src="${urlPublic }/img/${fruta.imagen}" /></td>
								<td>${fruta.procedencia }</td>
								<td>${fruta.precio }</td>
								<td><a href="eliminar/${fruta.id}"
									class="btn btn-danger btn-xs"><i
										class="glyphicon glyphicon-trash"></i> Eliminar</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<h1>Total: ${precio } E</h1>
				<a class="btn btn-success" href="pdf">Guardar PDF</a> <a
					class="btn btn-success" href="correo">Enviar por correo</a>
			</div>
		</div>
	</div>
</body>
</html>