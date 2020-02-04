package Aeropuerto;

public class Pasajero {
	
	private String nombre;
	private String nacionalidad;
	private String numpasaporte;
	public Pasajero(String nombre, String nacionalidad, String numpasaporte) {
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.numpasaporte = numpasaporte;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getNumpasaporte() {
		return numpasaporte;
	}
	public void setNumpasaporte(String numpasaporte) {
		this.numpasaporte = numpasaporte;
	}
	
	

}
