package edu.ucam.contador;

public class Contador {
	private int contador = 0;
	
	public synchronized void sumaUno(){
		this.contador++;
	}
	
	public int getEstado(){
		return this.contador;
	}
}
