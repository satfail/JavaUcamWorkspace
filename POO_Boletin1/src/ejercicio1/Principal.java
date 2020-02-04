package ejercicio1;

public class Principal {

	public static void main(String[] args) {
		
		//Objeto poligono sin datos, muestra por pantalla
		Poligono pol1 = new Poligono();
		
		// Objeto poligono con 4 lados
		pol1 = new Poligono(4);
		
		System.out.println("El poligono tiene " + pol1.getLados() + " lados");
	}
}
