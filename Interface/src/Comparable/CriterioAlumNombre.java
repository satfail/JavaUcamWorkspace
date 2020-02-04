package Comparable;

import Instituto.Alumno;

public class CriterioAlumNombre extends Criterio<Alumno> {

	public int comparar (Alumno a, Alumno b) {
		
		return a.getNombre().compareTo(b.getNombre());
	}
	
}
