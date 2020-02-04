package Instituto;


public class Alumno implements Comparable<Alumno> {

	private String nombre;
	private int edad;
	private double notaPromedio;
	
	//constructor de Alumno
	
	public Alumno(String nombre, int edad, double notaPromedio) {
		
		this.nombre = nombre;
		this.edad = edad;
		this.notaPromedio = notaPromedio;
		
	}
	
	public int compareTo (Alumno otroAlumno) { //hereda de Comparable
		
		return this.edad - otroAlumno.edad; // dependiendo del signo dice si precede o no, si es 0 es igual.
	}
	
	public String toString() {
		
		return nombre + " , " + edad + " , " + notaPromedio;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		
		this.nombre = nombre;
	}
	
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(String nombre) {
		
		this.edad = edad;
	}
	
	public double getNotaPromedio() {
		return notaPromedio;
	}
	
	public void setNotaPromedio(String nombre) {
		
		this.notaPromedio = notaPromedio;
	}
}
