package Aeropuerto;

public class Companya {
	
	private String nombre;
	private int numVuelo =0;
	private final int  MAX_VUELO = 10;
	private Vuelo listaVuelos[] = new Vuelo[MAX_VUELO];
	public Companya(String nombre) {
		super();
		this.nombre = nombre;
		this.numVuelo = numVuelo;
	}
	public Companya(String nombre, Vuelo listaVuelos[]) { ///Se pasan todos los vuelos
		super();
		this.nombre = nombre;
		this.listaVuelos = listaVuelos;
		numVuelo = listaVuelos.length;
	}
	
	public void insertarVuelo(Vuelo vuelo) {
		
		listaVuelos[numVuelo] = vuelo;
		numVuelo++;
	}
	public String getNombre() {
		return nombre;
	}
	public int getNumVuelo() {
		return numVuelo;
	}
	
	public Vuelo getVuelo(int i) {
		
		return listaVuelos[i];
	}
	
	public Vuelo getVuelo( String id) {
		
		boolean encontrado = false;
		int i = 0;
		Vuelo v = null;
		
		
		while((!encontrado) && (i < listaVuelos.length)) {
			
			if(id.equals(listaVuelos[i].getIdentificador())) {
				
				v = listaVuelos[i];
				encontrado = true;
				
				
			}
			i++;
		}
		
		return v;
		
	}
	
	
	 

}
