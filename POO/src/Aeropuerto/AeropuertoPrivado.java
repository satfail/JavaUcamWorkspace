package Aeropuerto;

public class AeropuertoPrivado extends Aeropuerto {
	
	private String listaEmpresas[] = new String[10];
	private int numEmpresa;
	
	
	
	public AeropuertoPrivado(String nombre, String ciudad, String pais) {
		super(nombre, ciudad, pais);
	}



	public AeropuertoPrivado(String nombre, String ciudad, String pais, Companya[] listacomp,String listaEmpresa[], int numEmpresa) {
		super(nombre, ciudad, pais, listacomp);
		this.listaEmpresas = listaEmpresa;
		this.numEmpresa = listaEmpresa.length;
	}
	
	public void insertarEmpresas(String e[]) {
		this.listaEmpresas = e;
		this.numEmpresa = e.length;
	}
	
	public void insertarEmpresa(String e) {
		listaEmpresas[numEmpresa] = e; //Contando el 0 siempre queda la ultima libre
		numEmpresa++;
		
	}



	public String[] getListaEmpresas() {
		return listaEmpresas;
	}



	public int getNumEmpresa() {
		return numEmpresa;
	}
	



	

	
	
	
	
	

}
