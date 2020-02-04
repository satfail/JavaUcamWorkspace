package ejercicio11;

public class Persona {

	private String nombre;
	private String apellido;
	private String direccion;
	public Persona(String nombre, String apellido, String direccion) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	
}
