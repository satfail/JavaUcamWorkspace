package ConstructorCopia;

public class Principal {

	public static void main(String[] args) {
	
	Coche miCoche = new Coche();
	Coche copiaCoche = new Coche(miCoche);
	System.out.println("Coche Copiado con Constructor");
	System.out.println(miCoche.toString());
	System.out.println(copiaCoche.toString());
	

		System.out.println("Furgonetas referenciadas");
	
	
	
		
	Furgoneta miFurgoneta= new Furgoneta(1000, 8);
	Furgoneta f = miFurgoneta;
	
	System.out.println(f.toString());
	System.out.println(miFurgoneta.toString());
	
	miFurgoneta.setMotor(100);
	
	//System.out.println( miFurgoneta.dimeDatos() + miFurgoneta.dimeDatosFurgo());
	
	

	
	
	
	
	
	
	
	
	}

}
