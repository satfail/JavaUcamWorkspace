package ejemploCriterios;

import java.util.Comparator;
import personal.Persona;

public class CriterioEdad implements Comparator<Persona> {

	@Override
	public int compare(Persona o1, Persona o2) {
		// TODO Auto-generated method stub
		if (o1.getEdad() < o2.getEdad()) return -1;
		if (o1.getEdad() > o2.getEdad()) return 1;
		return 0;
	}

}
