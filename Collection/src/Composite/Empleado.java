package Composite;

import java.util.List;

public interface Empleado {

    String getName();

    void add(Empleado e);

    void remove(Empleado e);

    List<Empleado> getEmployees();

    int calculatePoints();

}
