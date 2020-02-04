package edu.ucam;
public class Root {

	public static void main(String[] args) {
		Triangulo triangulo = new Triangulo();
		
		Thread hilo = new Thread(triangulo);
	}

}
