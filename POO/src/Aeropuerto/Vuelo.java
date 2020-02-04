package Aeropuerto;

public class Vuelo {
	
	private String identificador;
	private String ciudadOrigen;
	private String ciudadDestino;
	private double precio;
	private int numMaxVuelo;
	private int numActualVuelo;
	private Pasajero listaPasajeros[];
	
	public Vuelo(String identificador, String ciudadOrigen, String ciudadDestino, double precio, int numMaxVuelo) {
		super();
		this.identificador = identificador;
		this.ciudadOrigen = ciudadOrigen;
		this.ciudadDestino = ciudadDestino;
		this.precio = precio;
		this.numMaxVuelo = numMaxVuelo;
		this.numActualVuelo = 0;
		this.listaPasajeros = new Pasajero[numMaxVuelo];
	}
	
	public void insertarPasajero (Pasajero pasajero) {
		listaPasajeros[numActualVuelo] = pasajero;
		numActualVuelo++;
		
	}

	public String getIdentificador() {
		return identificador;
	}

	public String getCiudadOrigen() {
		return ciudadOrigen;
	}

	public String getCiudadDestino() {
		return ciudadDestino;
	}

	public double getPrecio() {
		return precio;
	}

	public int getNumMaxVuelo() {
		return numMaxVuelo;
	}

	public int getNumActualVuelo() {
		return numActualVuelo;
	}
	
	public Pasajero getPasajero(int i) {
		return listaPasajeros[i];
		
	}
	
	public Pasajero getPasajero(String pasaporte) {
		boolean encontrado = false;
		int i = 0;
		Pasajero pas = null;
		
		while((!encontrado) && (i < listaPasajeros.length)) {
			
			if (pasaporte.equals(listaPasajeros[i].getNumpasaporte())) {
				
				encontrado = true;
				pas = listaPasajeros[i];
			}
			
			i++;
			
		}
		return pas;
		
	}
	
	
	

}
