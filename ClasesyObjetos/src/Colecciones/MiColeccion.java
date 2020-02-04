package Colecciones;

public class MiColeccion {
	
	private Object datos[] = null ;
	private int len = 0;
	
	// En el constructor especificamos la capacidad inicial
	public MiColeccion (int capacidadInicial) {
		
		datos = new Object [capacidadInicial];
		
	}
	
	public Object obtener (int i) { ///Obtenemos la posicion introducida
		
		return datos[i];
	}
	
	public int cantidad() {  //Retorna cantidad de objetos, al crear ++ borrar --
		
		return len;
	}
	
	public void insertar (Object elm , int i) {
		
		if ( len == datos.length) {		//Si hemos llegado al max
			
			Object aux [] = datos;		//Me apoyo en aux
			datos = new Object[datos.length*2];		// Doblo 
			for(int j = 0; j < len; j++) {
				datos[j] = aux[j];					// Copio
				
			}
			
			aux = null;			// Elimino
		}
		
		for (int j = len -1 ; j >= i; j--) { //Muevo datos a la derecha para dejar insertar en i
			
			datos[j + 1] = datos[j];
		}
		
		datos[i] = elm; //Machaco el dato repetido que ya movi
		len++;			// Un objeto mas
		
	}
	
	
	public int buscar(Object elm) {
		
		int i = 0;
		for (; i < len && !datos[i].equals(elm); i++); //Recorre hasta el final o cuando encuentra objeto igual
		return i<len ? i : -1 ; //Si i es menor que la cantidad max devuelve la poscion o -1
								//Si no lo encuentra i va a ser mayor que len ---> -1	
	}
	
	public void agregar(Object elm) { //Agrega al final del array
		
		insertar(elm , len);
	}
	
	public Object eliminar(int i) {
		Object aux = datos[i];
		for (int j = i ; j < len -1 ; j++) { //Quiero borrar el i, paro en la penultima
			
			datos[j] = datos[j + 1]; ///Lo voy subiendo hasta el final, el ultimo queda igual
		}
		len--; //Un objeto menos.
		
		return aux; //retorno el objeto borrado.
	}
	
}
