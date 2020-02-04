package EjemploProductorConsumidor;
// Se meten y sacan carcateres de un array
//No se puede meter si esta lleno, ni sacar si esta vacio
//Tampoco se puede introducir si estamos sacando y viceversa
//Se utilizaran threats sincronizados para el correcto acceso al array
public class Monitor {

	private char[] buff = null;
	private int tope = 0;
	private boolean lleno = false;
	private boolean vacio = true;
	
	
	public Monitor (int capacidad) {	//Se sobrescribe el Constructor para crear el array con la capacidad dada
		
		buff = new char[capacidad];
	}
	
	public synchronized void poner (char c) throws Exception{
		
		//Si esta lleno espero
		while( lleno ) {
			wait();
		}
		
		//Seccion critica
		buff[tope++] = c ; //Fallo en el libro posicion 0 luego 1
		vacio = false;
		lleno = tope >= buff.length; //Si tope es mayor igual que el array, lleno igual true, entra en bucle
		notifyAll();//Pasa a ready los hilos que estan bloqueados
		
		
	}
	
	public synchronized char sacar () throws Exception{
		//Si esta vacio no saca
		
		while (vacio) {
			
			wait();
		}
		
		char c = buff[--tope]; // tope es igual a 1 resto primero
		lleno = false;
		vacio = tope <= 0; //Si es menor igual que 0 vacio igual a true
		notifyAll();
		return c;
	}
}
