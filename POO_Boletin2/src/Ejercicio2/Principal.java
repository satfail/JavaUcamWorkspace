package Ejercicio2;

public class Principal {
	
	public static void main(String[] args) {
		
		if (args[0].equals("2d")) {
			
			dosD punto2d = new dosD(3, 4);
			System.out.println(punto2d.toString() + " distancia = "+ punto2d.distanciaEuclidea() );
		}
		
		if (args[0].equals("3d")) {
			
			tresD punto3d = new tresD(3, 4,5);
			System.out.println(punto3d.toString() + " distancia = "+ punto3d.distanciaEuclidea() );
		}
		
		if (args[0].equals("4d")) {
			
			cuatroD punto4d = new cuatroD(3, 4, 5, 2);
			System.out.println(punto4d.toString() + " distancia = "+ punto4d.distanciaEuclidea() );
		}
		
	
	
	}
	

	
}


