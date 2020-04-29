<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear cuenta</title>
</head>
<body>
    <h1>Crear cuenta</h1>
    <form action="cuentaCliente?action=crearCuenta" method="post">
        <table>
            <tr>
                <td><label>Nombre</label></td>
                <td><input type="text" name="nombre"></td>
            </tr>
            <tr>
                <td><label></label>Apellido paterno</td>
                <td><input type="text" name="a_paterno"></td>
            </tr>
            <tr>
                <td><label>Apellido materno</label></td>
                <td><input type="text" name="a_materno"></td>
            </tr>
            <tr>
                <td><label>Correo electrónico</label></td>
                <td><input type="text" name="correo_e"></td>
            </tr>
            <tr>
                <td><label></label>Contraseña</td>
                <td><input type="text" name="contrasenia"></td>
            </tr>
            <tr>
                <td><label>Teléfono</label></td>
                <td><input type="text" name="telefono"></td>
            </tr>
            <tr>
                <td><label>Dirección</label></td>
                <td><input type="text" name="direccion"></td>
            </tr>
        </table>
        <input type="submit" name="crear" value="Crear">
    </form>
</body>
</html>