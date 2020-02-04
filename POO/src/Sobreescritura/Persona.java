package Sobreescritura;

public class Persona extends Animal{

	@Override
	public void comer() {
		
		System.out.println("Yo como de un plato");
	}
}
