package interfaces.ComparableAndComparator;
import java.util.Comparator;
public class Persona implements Comparable<Persona>, Comparator<Persona>{

    public int dni, edad;

     public Persona( int d, int e){

     this.dni = d;

     this.edad = e;

}



public int compareTo(Persona o) {

   int resultado=0;

   if (this.edad<o.edad) {   resultado = -1;      }

   else if (this.edad>o.edad) {    resultado = 1;      }

   else {

       if (this.dni<o.dni) {  resultado = -1;    }

       else if (this.dni>o.dni) {   resultado = 1;   }

       else {   resultado = 0;   }

   }

   return resultado;

}


// Ejercicio: implementar la intefaz Comparator con java.util.Comparator.

	public int getDni() {
	return dni;
}



public int getEdad() {
	return edad;
}



	public int compare(Persona p1, Persona p2) {
		
		return  p1.compareTo(p2);
	}

}
