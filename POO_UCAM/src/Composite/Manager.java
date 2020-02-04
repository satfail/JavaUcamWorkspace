package Composite;

import java.util.ArrayList;
import java.util.List;

public class Manager implements Empleado {

    private List<Empleado> empleados = new ArrayList<>();
    private String name;

    public Manager(String name) {
        this.name = name;
    }

    @Override
    public List<Empleado> getEmployees() {
        return this.empleados;
    }

    @Override
    public void add(Empleado e) {
        if (e != null) {
            this.empleados.add(e);
        }
    }

    @Override
    public void remove(Empleado e) {
        if (e != null) {
            this.empleados.remove(e);
        }
    }

    

    @Override
    public String getName() {
        return this.name;
    }

	@Override
	public int calculatePoints() {
		// TODO Auto-generated method stub
		if (this.empleados.isEmpty()) {
            return 0;
        }
        return Math.round(this.empleados.stream().mapToInt(e -> {
            System.out.println(e);
            return e.calculatePoints();
        }).sum());
	}

}