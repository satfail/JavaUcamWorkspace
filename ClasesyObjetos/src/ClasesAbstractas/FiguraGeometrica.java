package ClasesAbstractas;

public abstract class FiguraGeometrica {
	
	public abstract double area();// El area va a depender de la sublcase, es decir de la forma geometrica
								  // Aqui vemos el uso del polformismo transformamos la clase incial en las hijas
								  // Los metodos abstract no se resuelven por definicion, se hace posteriormente al concretar inf de las subclases
								  // Por lo tanto NO se pueden instanciar de la forma:
								  // FiguraGeometrica fg = new FiguraGeometrica ();
	
	private String nombre;
	
	public static double areaPromedio(FiguraGeometrica arr []) { //Los metodos se heredan, nos vale para calcular area promedio.
		int sum = 0;
		for( int i = 0; i < arr.length; i++) {
			
			sum += arr[i].area();
		}
		
		return sum/arr.length;
		
	}
	
	public FiguraGeometrica(String nombre) { //Constructor para recibir String como parametro
	
		this.nombre = nombre ;
		
	}
	
	public String toString() {
		
		return nombre + "  area = " + area ();  //Al estar area dentro de toString se esta invocando al metodo de la subclase en cuestion
									 // sobre la cual se invocó el metodo toString
	}
	
	
	public String getNombre() {  //getter de nombre
		
		return nombre;
	}
	
	public void setNombre(String nombre) {  ///Setter de nombre
		
		this.nombre = nombre;
	}

}
