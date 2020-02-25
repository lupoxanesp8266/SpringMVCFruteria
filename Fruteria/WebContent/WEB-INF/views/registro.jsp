<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro de usuario</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div id="login">
		<h3 class="text-center text-white pt-5">Registro en la frutería</h3>
		<div class="container">
			<div id="login-row"
				class="row justify-content-center align-items-center">
				<div id="login-column" class="col-md-6">
					<div id="login-box" class="col-md-12">
						<form:form id="login-form" class="form" action="registrarse"
							method="post">
							<h3 class="text-center text-info">Datos de usuario</h3>
							<div class="form-group">
								<label for="nombre" class="text-info">Nombre:</label><br>
								<form:input name="nombre" path="nombre" id="nombre"
									class="form-control" />
							</div>
							<div class="form-group">
								<label for="username" class="text-info">Usuario:</label><br>
								<form:input name="username" path="usuario" id="username"
									class="form-control" />
							</div>
							<div class="form-group">
								<label for="email" class="text-info">Email:</label><br>
								<form:input name="email" path="email" id="email"
									class="form-control" />
							</div>
							<div class="form-group">
								<label for="password" class="text-info">Password:</label><br>
								<form:input type="password" name="password" path="password"
									id="password" class="form-control" />
							</div>

							<div class="form-group text-center">
								<input type="submit" name="submit" value="Aceptar"
									class="btn btn-info btn-md" value="submit">
							</div>
							
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>