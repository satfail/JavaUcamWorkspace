package ClasesAbstractas;

public class Rectangulo extends FiguraGeometrica {
	
	private double base;
	private double altura;
	
	
	public Rectangulo(double b, double a) {
		super("Rectangulo"); //Llamamos al constructor de nombre si lo quitamos da error, xk el constructor ToString necesita este parametro.
		base = b;
		altura = a;
	}
	
	
	//De forma general una sublclase que proviene de una abstracta debe sobrescribir los metodos abstractos
	public double area() { 
		
		return base*altura;
	}
	
	
	public double getBase() {
		return base;
	}
	public void setBase(double base) {
		this.base = base;
	}
	
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
}
