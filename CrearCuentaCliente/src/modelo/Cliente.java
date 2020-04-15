package modelo;

public class Cliente {
	private String correo_e;
	private String nombre;
	private String a_paterno;
	private String a_materno;
	private String contrasenia;
	private String telefono;
	
	
	public Cliente(String correo_e, String nombre, String a_paterno, 
			       String a_materno, String contrasenia, String telefono) {
		this.correo_e = correo_e;
		this.a_paterno = a_paterno;
		this.a_materno = a_materno;
		this.contrasenia= contrasenia;
		this.telefono = telefono;
	}
	
	public String getCorreoE() {
		return correo_e;
	}
	
	public void set(String correo_e) {
		this.correo_e = correo_e;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getAPaterno() {
		return a_paterno;
	}
	
	public void seAPaternot(String a_paterno) {
		this.a_paterno = a_paterno;
	}
	
	public String getAMaterno() {
		return a_materno;
	}
	
	public void seAMaternot(String a_materno) {
		this.a_materno = a_materno;
	}
	
	
	public String getContrasenia() {
		return contrasenia;
	}
	
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
