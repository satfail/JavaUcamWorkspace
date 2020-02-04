package ClasesAbstractas;

public class TestFiguras {

	public static void main(String[] args) {
		Circulo c = new Circulo(4);
		Rectangulo r = new Rectangulo(10,5);
		Triangulo t = new Triangulo(3,6);
		System.out.println(c);
		System.out.println(r);
		System.out.println(t);
		
		System.out.println("-----------------------------------");
		
		FiguraGeometrica arr[] = { new Circulo(23), new Rectangulo(12,4) , new Triangulo(2,5)};
		double prom = FiguraGeometrica.areaPromedio(arr);
		
		for (int i = 0 ; i < arr.length ; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("El area promedio de las figuras es : " + prom);
	}
}
