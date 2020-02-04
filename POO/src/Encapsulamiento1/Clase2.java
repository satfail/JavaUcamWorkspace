package Encapsulamiento1;

public class Clase2 {

	public static void main(String[] args) {
		Clase1 objeto1 = new Clase1();
		objeto1.atributo1 = 15;
		//objeto1.atributo3 = 15; //Error es privado para Clase1
	}
}
