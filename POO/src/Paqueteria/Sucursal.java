package Paqueteria;

public class Sucursal {
	
	private  int numSucursal;
	private String direccion;
	private String ciudad;
	public Sucursal(int numSucursal, String direccion, String ciudad) {
		super();
		this.numSucursal = numSucursal;
		this.direccion = direccion;
		this.ciudad = ciudad;
	}
	
	public Sucursal() {

	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getNumSucursal() {
		return numSucursal;
	}
	
	public String mostrarDatosSucursal() {
		
		return "Nº Sucursal : "+ numSucursal
				+"\nDireccion : " + direccion
				+"\nCiudad : "+ ciudad;
	}
	
	public double calcular_precio(Paquete p) {
		double precioTotal;
		precioTotal = 0;
		if(p.getPrioridad() == 0)
			precioTotal = p.getPeso();
		if(p.getPrioridad() == 1) {
			// 10 dolares mas
			precioTotal +=10;
		}
		else
			precioTotal += 20;
		
		return precioTotal;
		
	}

	
	

}
