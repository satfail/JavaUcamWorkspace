package Ejercicio10;

public class Principal {
	
	public static void main(String[] args) {
		//Ejercicio 1
		Poligono pol1 = new Poligono();
		//Ejercicio 6
		Poligono pol2 = new Poligono(4);
		System.out.println("El numero de lados del Poligono es de : " + pol2.getnLados() );
		
		//Ejercicio 10
		Poligono pol3 = new Poligono(); //10.1
		pol3.getArea();//10.2
		pol3 = new Triangulo(3, 5, 6, 7);//10.3
		pol3.getArea();//10.4
		System.out.println("NLados " + pol3.getnLados());
	}

}
