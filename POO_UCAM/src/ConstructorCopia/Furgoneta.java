package ConstructorCopia;

public class Furgoneta extends Coche {
	
	private int capacidad_extra;
	private int num_plazas;
	
	
	public Furgoneta (int capacidad_extra, int num_plazas) {
		
		super();// llama al constructor de la clase coche
		this.capacidad_extra = capacidad_extra;
		this.num_plazas= num_plazas;

	}
	
	public Furgoneta(Furgoneta f) {
		this.capacidad_extra = f.capacidad_extra;
		this.num_plazas = f.num_plazas;
		
	}
	
	
	public String dimeDatosFurgo() {
		
		
		return "la capacidad de carga es: "+ capacidad_extra +"Las plazas son: " + num_plazas; 
		
		
		
		
	}
	
	
	

}
