package Aeropuerto;

public class AeropuertoPublico extends Aeropuerto{
	
	private double subvencion;

	public AeropuertoPublico(String nombre, String ciudad, String pais, Companya[] listacomp, double subvencion) {
		super(nombre, ciudad, pais, listacomp);
		this.subvencion = subvencion;
		
		
	}

	public AeropuertoPublico(String nombre, String ciudad, String pais) {
		super(nombre, ciudad, pais);
		
	}

	public AeropuertoPublico(String nombre, String ciudad, String pais, double subvencion) {
		super(nombre, ciudad, pais);
		this.subvencion = subvencion;
	}

	public double getSubvencion() {
		return subvencion;
	}
	
	
	
	
	
	

}
