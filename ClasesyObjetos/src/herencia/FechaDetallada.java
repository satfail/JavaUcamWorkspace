package herencia;

import ClasesyObjetos.Private_public_get_set;

public class FechaDetallada  extends Private_public_get_set{
	
	private static String meses[] = { "Enero", "Febrero", "Marzo" , "Abril", "Mayo","Junio",
									"Julio", "Agosto", "Septiembre", "Octubre","Noviembre","Diciembre"};
	//static --> Variable de clase, comun a todos los objetos.
	
	public String toString() {
		return getDia() + " de " + meses[getMes()-1] + " de " + getAnio();
	}
	
	///Llamamos a los constructures de fecha, ya que no se heredan por defecto
	
	public FechaDetallada(String f) { 
		super (f);						//Llamamos al que pilla el string y los separa en ints
	}
	
	public FechaDetallada( int dia , int mes , int anio) {
		
		super(dia,mes,anio);  //Llamamos al que nos coge los ints
	}
	
	public FechaDetallada() {
		
		this (0,0,0);			//Llamamos al constructor interior de la clase de los ints pasando 0
	}

}


//EN JAVA NO EXISTE LA HERENCIA MULTIPLE , POR LO TANTO, PARA CUALQUIER CLASE SIEMPRE SE TENDRÁ UN ÚNICO PADRE.