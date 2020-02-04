package Ejercicio10;
//Ejercicio 8
public class Rectangulo extends Poligono {

	private double altura;
	private double base;
	
	public Rectangulo(int nLados, double altura,double base) {
		super(nLados);
		nLados = 4;
		this.altura = altura;
		this.base = base;
	}

	public double getAltura() {
		return altura;
	}

	public double getBase() {
		return base;
	}
	//Ejercicio 9
	public void getArea() {
		
		System.out.println("El area es = " + base*altura);
	}
	
	public static int getNlados() {
		return nLados;
	}
	
	

}
