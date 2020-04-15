package modelo;


public class Direccion {
	private String correo_e;
	private String direccion;
	
	public Direccion(String correo_e, String direccion) {
		this.correo_e = correo_e;
		this.direccion = direccion;
	}
	
	public String getDireccion(){
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getCorreoE() {
		return correo_e;
	}
	
	public void serCorreoE(String correo_e) {
		this.correo_e = correo_e;
	}
}
