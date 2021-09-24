<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!String nombre, isbn, codigo, fecha_dev,mensaje;%>
	<%
	if (request.getParameter("isbn") != null) {
		nombre = request.getParameter("titulo");
		isbn=request.getParameter("isbn");
	}

	if (request.getParameter("men") != null) {
		
		mensaje = request.getParameter("men");
		out.print("<script>alert('" + mensaje + "');</script>");//mensaje alert javascript
	}
	%>
	<form action="Prestamo" method="post">

		<div>
			<label>Codigo Libro: </label><input type="text" name="codigo"
				required> <input type="submit" name="consultarlib"
				value="Consultar">
	</form>

	<form action="Prestamo" method="post">
		<label>Codigo prestamo: <%=codigo%></label>
		<div>
			<label>Nombre Libro: </label><input type="text" name="nombrelib"
				value="<%=nombre%>"> <input type="hidden" name="isbnlib"
				value="<%=isbn%>">
		</div>

		<div>
			<label>Estudiante: </label><input type="text" name="est" required>
			<div>
				<label>Fecha prestamo: </label><input type="date" name="fecha"
					required>

				<div>
					<label>Fecha devolucion: <%=fecha_dev%></label>
				</div>

				<div>
					<input type="submit" name="registrar" value="Regitrar">
				</div>
	</form>
</body>
</html>