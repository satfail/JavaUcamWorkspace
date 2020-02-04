package ejercicio11;

public class Principal {
	
	public static void main(String[] args) {
		
		TrabajadorExterno tExt1= new TrabajadorExterno("Miguel", "Gragera", "IncirlikBase", 6044.45f, 30);
		ClienteVip clVip1 = new ClienteVip("Miguel", "Gragera", "IncirlikBase", 4242424, 10);
		System.out.println(tExt1.getNombre() + " " + tExt1.getApellido() + " " +tExt1.getSalario());
		System.out.println(clVip1.getNombre()+ " " + clVip1.getDescuento() );
	}

}
