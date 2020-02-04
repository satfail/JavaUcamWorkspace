package herencia;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	
	
	Coche miCoche = new Coche();
	miCoche.setColor("azul");
	
	
		
	Furgoneta miFurgoneta= new Furgoneta(1000, 8);
	
	miFurgoneta.setMotor(100);
	
	System.out.println( miCoche.dimeDatos());
	System.out.println( miFurgoneta.dimeDatos() + miFurgoneta.dimeDatosFurgo());
	
	

	
	
	
	
	
	
	
	
	}

}
