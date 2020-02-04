package edu.ucam.contador;

public class HiloContador extends Thread{

	private Contador contador;

	public HiloContador(Contador contador) {
		this.contador = contador;
	}

	public void run(){
		for (int i = 0 ; i < 100 ; i++)
			this.contador.sumaUno();
	}
}
