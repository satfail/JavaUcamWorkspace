package ejercicio11;

public class ClienteVip  extends Cliente{

	private int descuento;

	
	public ClienteVip(String nombre, String apellido, String direccion, int cif,int descuento) {
		super(nombre, apellido, direccion, cif);
		this.descuento = descuento;
	}


	public int getDescuento() {
		return descuento;
	}
	
	
	
}
