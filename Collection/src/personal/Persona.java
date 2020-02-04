package personal;

public abstract class Persona {

	private String nombre;
	private int edad;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String getInformacion() {
		
		String cadena = "Nombre: " + nombre + " Edad: " + edad;
		
		cadena = cadena + getDetalle();
		
		return cadena;
	}
	
	public abstract String getDetalle();

	
}
