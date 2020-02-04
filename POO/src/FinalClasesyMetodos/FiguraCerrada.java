package FinalClasesyMetodos;

public  class FiguraCerrada extends Figura {//Al colocar final aqui, no se puede ejecutar 
	 //la clase heredada Cuadrado

	private int nLados;

	public FiguraCerrada(double tamano, int nLados) {
		super(tamano);
		this.nLados = nLados;
	}

	public int getnLados() {
		return nLados;
	}

	public void setnLados(int nLados) {
		this.nLados = nLados;
	}

	public  void dibujar() { //Al colocar final aqui, no se puede ejecutar 
								 //el metodo heredado en la clase Cuadrado
		
		System.out.println("El dibujo de una figura cerrada ");
	}
	
	
	
	
}
