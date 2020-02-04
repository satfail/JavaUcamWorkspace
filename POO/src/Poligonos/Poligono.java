package Poligonos;
//4 Pilares POO
	//Abstraccion
	//Encapsulamiento(Proteger Datos)
	//Herencia
	//Polimorfismo
public abstract class Poligono {
	
	protected int nLados;
	
	public Poligono(int nLados) {
		super();
		this.nLados = nLados;
	}
	
	public int getnLados() {
		return nLados;
	}

	public void setnLados(int nLados) {
		this.nLados = nLados;
	}

	
	@Override //Sobreescribe de Object
	public String toString() {
		return "Numero Lados = " + nLados;
	}

	public abstract double area();
	
	

}
