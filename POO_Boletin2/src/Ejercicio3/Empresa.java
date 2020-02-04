package Ejercicio3;

public class Empresa {
	
	private String nombreEmpresa;
	private Persona listaPersonas[];
	
	public Empresa(String nombreEmpresa, Persona[] listaPersonas) {
		this.nombreEmpresa = nombreEmpresa;
		this.listaPersonas = listaPersonas;
	}
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public Persona[] getListaPersonas() {
		return listaPersonas;
	}
	
	public String toString() {
		
		return nombreEmpresa;
		
	}
	
	public void mostrarPersonas() {
		
		for(Persona p : listaPersonas) {
			
			if (p instanceof Cliente) {
				
				System.out.println(p.toString() + " Se que es Cliente");
			}
			
			if (p instanceof Empleados) {
				
				System.out.println(p.toString() + " Se que es Empleado");
			}
		
		}
	}
	
	
	
	

}
