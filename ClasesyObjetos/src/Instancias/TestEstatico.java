package Instancias;

public final class TestEstatico {  //Final --> Estatico

	private int a = 0;
	public void unMetodo() {
		System.out.println( "Esto es un metodo ()");
		
	}
	
	public static void main(String[] args) {
		
		TestEstatico t = new TestEstatico(); /// Para acceder a las variables y metodos de la clase se instancia la clase
		System.out.println("a vale " + t.a); //Podemos acceder a las variables privadas por que el min esta dentro de la misma clase.
		t.unMetodo();
	}
}
