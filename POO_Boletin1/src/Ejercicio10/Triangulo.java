package Ejercicio10;
//Ejercicio 8
public class Triangulo extends Poligono{

	private double lado1;
	private double  lado2;
	private double lado3;
	
	public Triangulo(int nLados, double lado1, double lado2,double lado3) {
		super(nLados);
		nLados = 3;
		this.lado1 = lado1;
		this.lado2 = lado2;
		this.lado3 = lado3;
	}


	public void getArea() {
		double p = (lado1 + lado2 + lado3)/2;
		double area = Math.sqrt(p*(p-lado1)*(p-lado2)*(p-lado3));
		System.out.println("El area del Triangulo es : " + area);
	}
	
	public static int getNlados() {
		return nLados;
	}
	
	
	
	
}
