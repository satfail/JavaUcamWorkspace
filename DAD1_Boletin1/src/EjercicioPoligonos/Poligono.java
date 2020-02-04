package EjercicioPoligonos;

public class Poligono {
	//Ejercicio 3
	private int nLados = 0;
	//Ejercicio2
	public Poligono() {
		System.out.println("Poligono creado");
	}
	//Ejercicio4
	public Poligono(int nLados) {
		this.nLados = nLados;
	}
	//Ejercicio 5
	public int getnLados() {
		return nLados;
	}
	
	public void getArea() {
		System.out.println("No hay metodo para calcular el area definido");	
	}
	

}
