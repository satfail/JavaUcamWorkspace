package ClasesAbstractas;

public class Circulo extends FiguraGeometrica{

	private double radio;
	
	public Circulo(double r) {
		super("Circulo");
		radio = r;
	}
	
	public double area() {
		
		return Math.PI * Math.pow(radio, 2); ///pow(base, exponente)
	}
	
}
