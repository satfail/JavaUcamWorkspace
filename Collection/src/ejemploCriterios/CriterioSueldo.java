package ejemploCriterios;

import java.util.Comparator;

import personal.Empleado;

public class CriterioSueldo implements Comparator<Empleado> {

	@Override
	public int compare(Empleado o1, Empleado o2) {
		// TODO Auto-generated method stub
		if (o1.getSueldo() < o2.getSueldo()) return -1;
		if (o1.getSueldo() > o2.getSueldo()) return 1;
		return 0;
	}
	

}
