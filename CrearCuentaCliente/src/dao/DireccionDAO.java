package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Direccion;
import modelo.Conexion;

public class DireccionDAO {
	private Conexion con;
	private Connection connection;
	
	public DireccionDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	//Agregar direccion
	public boolean agregarDireccion(Direccion direccion) throws SQLException{
		String sql = "INSERT INTO direccion_cliente (correo_e, direccion) VALUES (?, ?)";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, direccion.getCorreoE());
		statement.setString(2, direccion.getDireccion());
		boolean agregar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return agregar;
	}
	
	//Eliminar direccion
	public boolean eliminarDireccion(Direccion direccion) throws SQLException {
		boolean eliminar = false;
		String sql = "DELETE FROM direccion_cliente WHERE correo_e=?, direccion=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, direccion.getCorreoE());
		statement.setString(2, direccion.getDireccion());
		eliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return eliminar;
	}
}
