package Ejercicio4;

public class Principal {
	
	public static void main(String[] args) {
		
		Caja cajaNumeros = new Caja();
		
		cajaNumeros.setValor(10.452);
		System.out.println("Parte entera = " + cajaNumeros.intValue() );
	}

}
