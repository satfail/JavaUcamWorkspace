package EjercicioPoligonos;
//Ejercicio 8
public class Rectangulo extends Poligono {

	private double altura;
	private double base;
	
	public Rectangulo(int nLados, double altura,double base) {
		super(nLados);
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
	
	
	
	

}
