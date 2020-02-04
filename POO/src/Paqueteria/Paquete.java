package Paqueteria;

public class Paquete {
	
	private  int numeroPaquete;
	private  String dni;
	private double peso;
	private int prioridad;
	
	public Paquete(int numeroPaquete, String dni, double peso, int prioridad) {
		super();
		this.numeroPaquete = numeroPaquete;
		this.dni = dni;
		this.peso = peso;
		this.prioridad = prioridad;
	}
	
	public Paquete() {
		
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public int getNumeroPaquete() {
		return numeroPaquete;
	}

	public String getDni() {
		return dni;
	}
	
	
	public String mostrarDatosPaquete ( ) {
		
		return "Nº de Paquete " + numeroPaquete 
				+ "\nDNI : " + dni 
				+"\nPeso : " + peso
				+"\n Prioridad : " + prioridad;
	}
	
	

}
