<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar Dirección</title>
</head>
<body>
	<h1>Agregar Dirección</h1>
	<form action="adminCliente?action=agregarDir" method="post" >
		<table>
			<tr>
				<td><label>Direccion</label></td>
				<td><input type="text" name="direccion"></td>
			</tr>
		</table>
		<input type="submit" name="guardar" value="Guardar"> 
		<input type="submit" name="cancelar" value="Cancelar">
	</form> 
</body>
</html>