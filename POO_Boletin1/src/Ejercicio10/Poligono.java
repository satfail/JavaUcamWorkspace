package Ejercicio10;

public class Poligono {

	protected static int nLados = 0;

	public Poligono() {
		System.out.println("Poligono creado");
	}

	public Poligono(int nLados) {
		this.nLados = nLados;
	}

	public int getnLados() {
		return nLados;
	}
	
	public void getArea() {
		System.out.println("No hay metodo para calcular el area definido");	
	}
	

}
