package Ejercicio3;

public class Persona {
	
	protected String nombre;
	protected int edad;
	public Persona(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}
	public String getNombre() {
		return nombre;
	}
	public int getEdad() {
		return edad;
	}
	
	public String toString() {
		
		return nombre + " edad = " + edad;
	}
	
	

}
