package Genericas;

public class MiColeccion<T> { //Hacemos la Clase generica, el tipo de datos debe ser el parametro de elm
	
	private Object datos[] = null;
	private int len = 0 ;
	
	public MiColeccion(int capacidadInicial) {
		
		datos = new Object[capacidadInicial];
	}
	
	public void agregar(T elm) { /// un elemento con el tipo de dato T 
		
		insertar(elm , len);
	}
	
	public int cantidad () {
		
		return len;
	}
	
	public void  insertar(T elm, int i) {
		
		if (len == datos.length) {
			Object aux[] = datos;
			datos = new Object[datos.length*2];
			for(int j = 0 ; j< len ; j++) {
				
				datos[j] = aux[j];
			}
			
			aux = null;
		}
		for( int j = len -1 ; j >= i ; j--) { //Muevo datos a la derecha y meto en i
			
			datos[j + 1] = datos[j];
		}
		
		datos[i] = elm ;
		len ++;
	}
	
	public int buscar (T elm) {
		
		int i = 0;
		for( ; i < len && !datos[i].equals(elm); i++);
		return i < len ? i : -1 ; //Retorno la posicion que busco o -1 si no lo encuentro
	}
	
	@SuppressWarnings ("unchecked")
	public T eliminar (int i) {
		
		Object aux = datos[i];
		for(int j = i; j < len -1 ; j++) {
			datos[j] = datos[j + 1];
		}
		len--;
		return (T)aux;
	}
	
	@SuppressWarnings ("unchecked")
	public T obtener(int i) {
		
		return (T)datos[i];
	}
	
	
}
