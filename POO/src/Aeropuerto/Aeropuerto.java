package Aeropuerto;

public class Aeropuerto {
	
	private String nombre;
	private String ciudad;
	private String pais;
	private Companya listacomp[] = new Companya[10];
	private int numcomp;
	public Aeropuerto(String nombre, String ciudad, String pais) {
		super();
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.pais = pais;
		this.numcomp = 0;
		
	}
	public Aeropuerto(String nombre, String ciudad, String pais, Companya listacomp[]) {
		super();
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.pais = pais;
		this.numcomp = 0;
		this.listacomp = listacomp;
		
	}
	public String getNombre() {
		return nombre;
	}
	public String getCiudad() {
		return ciudad;
	}
	public String getPais() {
		return pais;
	}
	public int getNumcomp() {
		return numcomp;
	}
	
	public void insertarComp(Companya c) {
		
		listacomp[numcomp] = c;
		numcomp++;
		
	}
	public Companya[] getListacomp() {
		return listacomp;
	}
	
	public Companya getComp (int i) {
		return listacomp[i];
	}
	
	public Companya getComp(String nombre) {
		Companya c = null;
		boolean encontrado = false;
		int i = 0;
		while((!encontrado)&& (i < listacomp.length) ){
			
			if(nombre.equals(listacomp[i].getNombre())) {
				c = listacomp[i];
				encontrado = true;
			}
			i++;
			
		}
		
		return c;
		
	}
	
	
	
	

}
