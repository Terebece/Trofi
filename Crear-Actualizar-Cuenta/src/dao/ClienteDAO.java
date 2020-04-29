package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	// Agregar cliente
	public boolean agregarCuenta(Cliente cliente) throws SQLException {
		String sql = "INSERT INTO cliente (correo_e, nombre, a_paterno, a_materno, contrasenia, telefono) VALUES (?, ?, ?, ?, SHA(?), ?)";
		System.out.println("conectando");
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, cliente.getCorreoE());
		statement.setString(2, cliente.getNombre());
		statement.setString(3, cliente.getAPaterno());
		statement.setString(4, cliente.getAMaterno());
		statement.setString(5, cliente.getContrasenia());
		statement.setString(6, cliente.getTelefono());
		System.out.println("agregado");
		boolean agregar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return agregar;
	}
	
	// Actualizar cliente 
	public boolean actualizarCuenta(Cliente cliente) throws SQLException {
		boolean actualizar = false;
		String sql = "UPDATE cliente SET nombre = ?, a_paterno = ?, a_materno = ?, telefono = ? WHERE correo_e = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, cliente.getNombre());
		statement.setString(2, cliente.getAPaterno());
		statement.setString(3, cliente.getAMaterno());
		statement.setString(4, cliente.getTelefono());
		statement.setString(5, cliente.getCorreoE());
		actualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return actualizar;
	}
	
	// Obtener cliente por correo_e
	public Cliente obtenerCuenta(String correo_e) throws SQLException {
		Cliente cliente = null;
		String sql = "SELECT * FROM cliente WHERE correo_e = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, correo_e);
		
		ResultSet res = statement.executeQuery();
		if(res.next()) {
			cliente = new Cliente(res.getString("nombre"), res.getString("a_paterno"), res.getString("a_materno"), 
								  res.getString("correo_e"), res.getString("contrasenia"), res.getString("telefono"));
		}
		res.close();
		con.desconectar();
		return cliente;
	}
}
