package FinalClasesyMetodos;

//No deja heredar de Figura cerrada por que es final
public class Cuadrado extends FiguraCerrada {

	public double area;
	public Cuadrado(double tamano, int nLados, double area) {
		super(tamano, nLados);
		this.area = area;
		
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	
	public void dibujar() { //No deja tenerlo porque el de FiguraCerrada es Final
							// y tienen el mimos nombre
		
		System.out.println("Dibujamos un cuadrado");
	}

	
}
