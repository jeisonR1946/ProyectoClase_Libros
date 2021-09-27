<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!String mensaje="";
String codigo="",titulo="",editorial="",autor="",estado="";
int paginas=0;
%>
<h1>Modulo Libros</h1>
<hr>
<%
if(request.getParameter("codigo")!=null){
codigo=request.getParameter("codigo");
titulo= request.getParameter("titulo");
editorial=request.getParameter("editorial");
autor=request.getParameter("autor");
paginas=Integer.parseInt(request.getParameter("paginas"));
estado="disabled";
}
%>
<%
if(request.getParameter("men")!=null){
codigo="";
titulo="";
editorial="";
autor="";
paginas=0;
estado="";
mensaje=request.getParameter("men");
out.print("<script>alert('"+mensaje+"');</script>");//mensaje alert javascript
}
%>
<form action="Libro" method="post">
<fieldset>
<legend>Datos del Libro:</legend>
<div><label>Codigo: </label><input type="text" name="isbn" value="<%=codigo%>" required <%=estado%>></div>
<input type="hidden" name="cod" value="<%=codigo%>">
<div><label>Titulo: </label><input type="text" name="titulo" value="<%=titulo%>" required></div>
<div><label>Editorial: </label><input type="text" name="editorial" value="<%=editorial%>" required></div>
<div><label>Autor: </label><input type="text" name="autor" value="<%=autor%>" required></div>
<div><label>Paginas: </label><input type="number" name="paginas" value="<%=paginas%>"></div>
<div><input type="submit" name="registrar" value="Registrar">
<input type="submit" name="actualizar" value="Actualizar">
<input type="submit" name="eliminar" value="Eliminar"></div>
</fieldset>
</form>
<form action="Libro" method="post">
<fieldset>
<legend>Consultar</legend>
<div><label>Codigo: </label><input type="text" name="codigo" required></div>
<div><input type="submit" name="consultar" value="Consultar"></div>
</fieldset>
</form>
<hr>
<form action="Libro" method="post" enctype="multipart/form-data">
<div><label>Archivo: </label><input type="text" name="nombreArchivo">
<input type="file" value="Examinar" name="archivo"></div>
<div><input type="submit" name="cargar" value="Cargar Archivo tipo CSV"></div>
</form>
</body>
</html>





