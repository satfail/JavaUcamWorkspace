package herencia2;
import java.util.*;

public class Empleado {
	
	
	private  String nom;
	private double sueldo;
	int agn;
	int mes;
	int dia;
	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}



	public double dameSueldo() {
		return sueldo;
	}



	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}


	private Date altaContrato;
	
	// Sobrecarga de constructores
	
	public Empleado(String nom, double sueldo, int agn, int mes, int dia) {
	
		this.nom = nom;
		this.sueldo = sueldo;
		GregorianCalendar calendario= new GregorianCalendar(agn,mes-1,dia);
		altaContrato =calendario.getTime();
		
	}
	
	
	
	public Empleado (String nom) {
						
				this(nom,3000,2000,01,01); ///para rellenar los campos por defecto y unicamente modifiacar el nombre
				
	}
	
	
	public Empleado () {
		
		nom="Mada";
		sueldo= 1000;
		
}



	public String toString (){
        String mensaje="El empleado se llama "+ nom +
                " y tiene un salario de "+ sueldo;
        return mensaje;
    }
	


	
	
	
	
	
	
	
	
	
	
	
	

}
