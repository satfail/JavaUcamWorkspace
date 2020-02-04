package miSerializable;

import java.io.Serializable;

public class Persona implements Serializable {
	
	private String nombre;
	private int edad;
	private String dni;
	public Persona(String nombre, int edad, String dni) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public int getEdad() {
		return edad;
	}
	public String getDni() {
		return dni;
	}
	
	public  void printdata(Persona p1) {
		
	    System.out.println("nombre = " +p1.nombre); 
	    System.out.println("edad = " + p1.edad); 
	    System.out.println("dni = " + p1.dni); 

		
		
	}
	

	
	
	

}
