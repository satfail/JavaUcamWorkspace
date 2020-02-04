package edu.ucam.aplicacion;

public class Mecanico extends Persona{
	
	private static final long serialVersionUID = 1L;
	private float sueldo;
	private int antieguedad;
	private boolean estadoTrabajando;
	
	//Constructores
	public Mecanico() {
		super();
	}

	public Mecanico(String nombre, String apellido, String dni, Automovil auto) {
		super(nombre, apellido, dni,auto);

	}



	public Mecanico(String nombre, String apellido, String dni, Automovil auto, float sueldo, int antieguedad,
			boolean estadoTrabajando) {
		super(nombre, apellido, dni, auto);
		this.sueldo = sueldo;
		this.antieguedad = antieguedad;
		this.estadoTrabajando = estadoTrabajando;
	}
	
	//Constructor Copia
	public Mecanico(Mecanico c) {
		setNombre(c.getNombre());
		setApellido(c.getApellido());
		setDni(c.getDni());
		setAuto(c.getAuto());
		this.sueldo = c.getSueldo();
		this.antieguedad = c.getAntieguedad();
		this.estadoTrabajando = c.isEstadoTrabajando();
		
	}
	//Getters y Setters
	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	public int getAntieguedad() {
		return antieguedad;
	}

	public void setAntieguedad(int antieguedad) {
		this.antieguedad = antieguedad;
	}

	public boolean isEstadoTrabajando() {
		return estadoTrabajando;
	}

	public void setEstadoTrabajando(boolean estadoTrabajando) {
		this.estadoTrabajando = estadoTrabajando;
	}


	public String toString() {
		return super.toString() + getDetalle();
	}

	@Override
	public String getDetalle() {
		return "\t Mecanico:  Sueldo = " + getSueldo() + " Antiguendad " + getAntieguedad() + " Estado de Trabajo : " + isEstadoTrabajando();
	}


	
	
	
	

}
