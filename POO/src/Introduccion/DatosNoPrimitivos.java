package Introduccion;

public class DatosNoPrimitivos {

	public static void main(String[] args) {
		
		Integer numero = null; //Este tipo de datos pueden ser null
		numero = 0;
		for (int i = 0 ; i< 10; i++) {
			numero += 1;
			System.out.println(numero);
		}
		
		if(numero.equals(10)) //Tb tienen metodo
			System.out.println("El numero es 10");
	}
	
}
