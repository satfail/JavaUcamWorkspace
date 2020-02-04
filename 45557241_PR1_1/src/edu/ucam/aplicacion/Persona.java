package edu.ucam.aplicacion;

import java.io.Serializable;

public abstract class Persona implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String apellido;
	private String dni;
	private Automovil auto;
	//Constructores
	public Persona(String nombre, String apellido, String dni, Automovil auto) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.auto = auto;
	}
	
	public Persona() {}
	//Constructor Copia
	public Persona (Persona p) {
		
		this.nombre = p.getNombre();
		this.apellido = p.getApellido();
		this.dni = p.getDni();
		
	}
	//Getters y Setters
	public String getNombre() {
		return nombre;
	}
	//toString sobreescrito de Object
	@Override
	public String toString() {
		return "Nombre=" + nombre + ", Apellido=" + apellido + ", Dni=" + dni + "\n";
	}
	
	public abstract String getDetalle();
	//Getters y Setters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return apellido;
	}

	public String getDni() {
		return dni;
	}

	public Automovil getAuto() {
		return auto;
	}

	public void setAuto(Automovil auto) {
		this.auto = auto;
	}
	
	
	
	
	

}
