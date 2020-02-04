package FinalClasesyMetodos;
// Cuadrado --> FiguraCerrada
								//-->Figura
//				FiguraAbierta
//Hay veces que quieres que una clase no tenga mas hijos
//Para eso utilizamos final para clases

//Para metodos final, si quiero que las subclases no tengan el mismo nombre
//de un metodo de la clase padre, para evitar esto declaramos final en el metodo
//de la clase padre
public class Figura {
	
	private double tamano;

	public Figura(double tamano) {
		super();
		this.tamano = tamano;
	}

	public double getTamano() {
		return tamano;
	}

	public void setTamano(double tamano) {
		this.tamano = tamano;
	}
	

}
