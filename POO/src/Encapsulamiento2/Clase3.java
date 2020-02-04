package Encapsulamiento2;

import Encapsulamiento1.Clase1; //Para acceder a la clase 1 de otro paquete
public class Clase3 {

	public static void main(String[] args) {
		Clase1 objeto1 = new Clase1();
		//objeto1.atributo1 = 15; //Error porque no es publico el atributo1
		objeto1.atributo2 = 15; //Aqui no hay error porque es publico este atributo
	}
}
