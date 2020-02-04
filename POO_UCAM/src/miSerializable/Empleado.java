package miSerializable;

public class Empleado extends Persona {
	
	private String puesto;
	private float salario;
	
	
	public Empleado(String nombre, int edad, String dni) {
		super(nombre, edad, dni);
		this.puesto = "";
		this.salario = 0.0f;
	}


	public Empleado(String nombre, int edad, String dni, String puesto, float salario) {
		super(nombre, edad, dni);
		this.puesto = puesto;
		this.salario = salario;
	}
	
	
	public  void printdata(Empleado e) {
		
	    System.out.println("nombre = " +e.getNombre()); 
	    System.out.println("edad = " + e.getEdad()); 
	    System.out.println("dni = " + e.getDni());
	    System.out.println("puesto = " +e.puesto); 
	    System.out.println("salario = " + e.salario);		
		
	}
	
	
	
	

}
