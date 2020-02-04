package Genericas;

public class Pareja <T>{
	
	private T primero;
	
	public Pareja(){
		
		primero = null;
	}
	
	public void setPrimero(T nuevoValor) { //entra generico
		
		primero = nuevoValor;
	}
	
	public T getPrimero(){ //Devuelve generico
		
		return primero;
	}
	


}
