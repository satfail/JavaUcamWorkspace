package Ejercicio3;

public class Empleados extends Persona {

	private float sueldo;
	
	
	public Empleados(String nombre, int edad,float sueldo) {
		super(nombre, edad);
		this.sueldo = sueldo;
	}


	public float getSueldo() {
		return sueldo;
	}
	
	
	public String toString() {
		
		return super.toString() + " sueldo = " + sueldo;
	}
	

}
