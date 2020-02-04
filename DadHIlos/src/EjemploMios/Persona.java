package EjemploMios;

public class Persona {
	
	protected String nombre;
	protected int numero;
	protected int velocidad;
	public Persona(String nombre, int numero, int velocidad) {
		super();
		this.nombre = nombre;
		this.numero = numero;
		this.velocidad = velocidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	
	

}
