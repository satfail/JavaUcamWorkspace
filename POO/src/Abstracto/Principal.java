package Abstracto;

public class Principal {

	public static void main(String[] args) {
		//Animal an = new Animal(); //Esto da error porque es Abstracta, no instancia objetos
		ACarnivoro leon = new ACarnivoro();
		Aherbivoro vaca = new Aherbivoro();
		Planta margarita = new Planta();
		
		leon.alimentarse();
		margarita.alimentarse();
		vaca.alimentarse();
		
		
	}
}
