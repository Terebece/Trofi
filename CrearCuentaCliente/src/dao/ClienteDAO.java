package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Cliente;
import modelo.Conexion;

public class ClienteDAO {
	
	private Conexion con;
	private Connection connection;
	
	public ClienteDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	//Crear cuenta 
	public boolean crearCuenta(Cliente cliente) throws SQLException{
		String sql = "INSERT INTO cliente (correo_e, nombre, a_paterno, a_materno, contrasenia, telefono) VALUES (?, ?, ?, AES_ENCRYPT(?, 'key'), ?)";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, cliente.getCorreoE());
		statement.setString(2, cliente.getNombre());
		statement.setString(3, cliente.getAPaterno());
		statement.setString(4, cliente.getAMaterno());
		statement.setString(4, cliente.getContrasenia());
		statement.setString(6, cliente.getTelefono());
		boolean crear = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return crear;
	}
	
	
	//Actualizar cuenta
	public boolean actualizarCuenta(Cliente cliente) throws SQLException{
		boolean actualizar = false;
		String sql = "UPDATE cliente SET nombre=?,a_paterno=?,a_materno=?, contrasenia=AES_ENCRYPT(?, 'key'),telefono=? WHERE correo_e=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, cliente.getNombre());
		statement.setString(2, cliente.getAPaterno());
		statement.setString(3, cliente.getAMaterno());
		statement.setString(4, cliente.getContrasenia());
		statement.setString(5, cliente.getTelefono());
		statement.setString(6, cliente.getCorreoE());
		actualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return actualizar;
	}
	
	//Eliminar direccion
	public boolean eliminarDireccion(Cliente cliente) throws SQLException {
		boolean eliminar = false;
		boolean eliminar1 = false;
		boolean eliminar2 = false;
		String sql = "DELETE FROM cliente WHERE correo_e=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, cliente.getCorreoE());
		eliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		
		String sql1 = "DELETE FROM orden WHERE correo_e=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement1 = connection.prepareStatement(sql1);
		statement1.setString(1, cliente.getCorreoE());
		eliminar = statement1.executeUpdate() > 0;
		statement1.close();
		con.desconectar();
		
		String sql2 = "DELETE FROM tiene WHERE correo_e=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement2 = connection.prepareStatement(sql2);
		statement2.setString(1, cliente.getCorreoE());
		eliminar = statement2.executeUpdate() > 0;
		statement2.close();
		con.desconectar();

		return eliminar && eliminar1 && eliminar2;
	}
	
}
