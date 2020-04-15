
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar Cuenta</title>
</head>
<body>
	<h1>Crear Cuenta</h1>
	  <form action="adminCliente?action=actualizar" method="post" >
		<table>
			<tr>
				<td><label>Nombre</label></td>
				<td><input type="text" name="nombre" value="<c:out value="${cliente.nombre}"></c:out>"></td>
			</tr>
			<tr>
				<td><label>Apellido paterno</label></td>
				<td><input type="text" name="a_paterno" value="<c:out value="${cliente.a_paterno}"></c:out>"></td>
			</tr>
			<tr>
				<td><label>Apellido materno</label></td>
				<td><input type="text" name="a_materno" value="<c:out value="${cliente.a_materno}"></c:out>"></td>
			</tr>
			<tr>
				<td><label>Correo electrónico</label></td>
				<td><input type="text" name="correo_e" value="<c:out value="${cliente.correo_e}"></c:out>"></td>
			</tr>
			<tr>
				<td><label>Contraseña</label></td>
				<td><input type="text" name="contrasenia" value="<c:out value="${cliente.contrasenia}"></c:out>"></td>
			</tr>
			
			<tr>
				<td><label>Teléfono</label></td>
				<td><input type="text" name="telefono" value="<c:out value="${cliente.telefono}"></c:out>"></td>
			</tr>
		</table>
	
		<input type="submit" name="guardar" value="Guardar"> 
	  </form>
</body>
</html>