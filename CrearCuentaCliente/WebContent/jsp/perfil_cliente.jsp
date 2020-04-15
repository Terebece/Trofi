<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Perfil Cliente</title>
</head>
<body>
	<h1>Perfil cliente</h1>
	<form action="adminCliente?action=crearCuenta" method="post" >
		<table>
			<tr>
				<td><label>Nombre</label></td>
				<td><c:out value="${cliente.nombre}"/></td>
			</tr>
			<tr>
				<td><label>Apellido paterno</label></td>
				<td><c:out value="${cliente.a_paterno}"/></td>
			</tr>
			<tr>
				<td><label>Apellido materno</label></td>
				<td><c:out value="${cliente.a_materno}"/></td>
			</tr>
			<tr>
				<td><label>Correo electrónico</label></td>
				<td><c:out value="${cliente.correo_e}"/></td>
			</tr>
			<tr>
				<td><label>Contraseña</label></td>
				<td><c:out value="${cliente.contrasenia}"/></td>
			</tr>
			
			<tr>
				<td><label>Telefono</label></td>
				<td><c:out value="${cliente.telefono}"/></td>
			</tr>
			
			<tr>
				<td><label>Dirección</label></td>
				
			</tr>
		</table>
	
		<input type="submit" name="registrar" value="Guardar"> 
	</form>
	
</body>
</html>