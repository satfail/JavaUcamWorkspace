package herencia2;

public class  Jefatura extends Empleado{
	
		
	private double incentivo;
	
	public Jefatura() {
		
		super();
		incentivo=10;
	}
	
	
	//si la clase padre  tiene  un constructor vacio de parámetros podríamos haber creado un constructor
	//de jefatura sin pasarle parámetros	
	
	
	
	
	//si dejamos la clase sin contructor por defecto llama a public Empleado(), 
	//le pasamos los paramétros de alguno de los constructores creados
	
	public Jefatura(String nom, double sueldo, int agn, int mes, int dia) {
		
		super(nom, sueldo, agn,mes,dia); 
		incentivo=20;
	}
	
	
	
	//estamos obligados a introducir los parámetos del padre
	//siempre dependiendo del numero de parámetros del constructor del padre que estemos usando
	
	
	
	public Jefatura(String nom) {
			
		super(nom);
		incentivo=40;
		
				
	}
	
	

	
	
	
	
	public void estableceIncentivo(double b) {
		
		incentivo= b;
	}
	
	
	
	public double dameSueldo() {
		
		double sueldoJefe = super.dameSueldo(); //el sueldo de la clase padre por tanto ponemos super
		return sueldoJefe+incentivo;
	}
	
	
	public String toString (){
        String mensaje=super.toString() + "su incentivo es de"+incentivo;
        return mensaje;
    }
	
	



}
