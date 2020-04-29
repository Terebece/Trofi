package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import dao.DireccionDAO;
import modelo.Cliente;
import modelo.Direccion;

@WebServlet("/cuentaCliente")
public class CuentaCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClienteDAO clienteDAO;
	DireccionDAO direccionDAO;
	String correo;
	
	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try { 
			clienteDAO = new ClienteDAO(jdbcURL, jdbcUsername, jdbcPassword);
			direccionDAO = new DireccionDAO(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) { 
			
		}
	}
	
	public CuentaCliente() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola ...");
		String action = request.getParameter("action");
		try {
			switch (action) {
			case "index":
				index(request, response);
				break;
			case "nuevaCuenta":
				nuevaCuenta(request, response);
				break;
			case "crearCuenta":
				crearCuenta(request, response);
				break;
			case "mostrarPerfil":
				mostrarPerfil(request, response);
				break;
			case "mostrarActualizarCuenta":
				mostrarActualizarCuenta(request, response);
				break;
			case "actualizarCuenta":
				actualizarCuenta(request, response);
				break;
			case "mostrarDirecciones":
				mostrarDirecciones(request, response);
				break;
			case "nuevaDireccion":
				nuevaDireccion(request, response);
				break;
			case "agregarDireccion":
				agregarDireccion(request, response);
				break;
			case "eliminarDireccion":
				eliminarDireccion(request, response);
				break;
			default:
				break;
			}
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola ....");
		doGet(request, response);
	}
	
	private void index(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher= request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
	
	private void nuevaCuenta(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher= request.getRequestDispatcher("/jsp/crearCuenta.jsp");
		dispatcher.forward(request, response);
	}
	
	private void crearCuenta(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		Cliente cliente = new Cliente(request.getParameter("nombre"), request.getParameter("a_paterno"), request.getParameter("a_materno"), request.getParameter("correo_e"), request.getParameter("contrasenia"), request.getParameter("telefono"));
		clienteDAO.agregarCuenta(cliente);
		correo = cliente.getCorreoE();
		Direccion direccion = new Direccion(request.getParameter("correo_e"), request.getParameter("direccion"));
		direccionDAO.agregarDireccion(direccion);
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("/jsp/inicio.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarPerfil(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/perfilCliente.jsp");
        Cliente cliente = clienteDAO.obtenerCuenta(correo);
        request.setAttribute("nombre", cliente.getNombre());
        request.setAttribute("paterno", cliente.getAPaterno());
        request.setAttribute("materno", cliente.getAMaterno());
        request.setAttribute("correo", cliente.getCorreoE());
        request.setAttribute("telefono", cliente.getTelefono());
        dispatcher.forward(request, response);
	}
	
	private void mostrarActualizarCuenta(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		Cliente cliente = clienteDAO.obtenerCuenta(correo);
        request.setAttribute("nombre", cliente.getNombre());
        request.setAttribute("paterno", cliente.getAPaterno());
        request.setAttribute("materno", cliente.getAMaterno());
        request.setAttribute("telefono", cliente.getTelefono());
		RequestDispatcher dispatcher= request.getRequestDispatcher("/jsp/actualizarCuenta.jsp");
		dispatcher.forward(request, response);
	}
	
	private void actualizarCuenta(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		Cliente cliente = new Cliente(request.getParameter("nombre"), request.getParameter("paterno"), request.getParameter("materno"), correo, " ", request.getParameter("telefono"));
		clienteDAO.actualizarCuenta(cliente);
		mostrarPerfil(request, response);
	}
	
	// Revisar aquí
	private void mostrarDirecciones(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/direcciones.jsp");
	    List<Direccion> direcciones = direccionDAO.obtenerDirecciones(correo);
	    request.setAttribute("direcciones", direcciones);
	    dispatcher.forward(request, response);
	}
	
	private void nuevaDireccion(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher= request.getRequestDispatcher("/jsp/agregarDireccion.jsp");
		dispatcher.forward(request, response);
	}
	
	private void agregarDireccion(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		Direccion direccion = new Direccion(request.getParameter("correo_e"), request.getParameter("direccion"));
		direccionDAO.agregarDireccion(direccion);
		RequestDispatcher dispatcher= request.getRequestDispatcher("/jsp/perfilCliente.jsp");
		dispatcher.forward(request, response);
	}
	
	private void eliminarDireccion(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		Direccion direccion = new Direccion(correo, request.getParameter("direccion"));
		direccionDAO.eliminarDireccion(direccion);
		RequestDispatcher dispatcher= request.getRequestDispatcher("/jsp/perfilCliente.jsp");
		dispatcher.forward(request, response);
	}
	
}
