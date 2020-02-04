package Composite;

import java.util.List;
import java.util.Random;

public class Developer implements Empleado {

    String name;

    public Developer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void add(Empleado e) {
    // nothing to implement
    }

    @Override
    public void remove(Empleado e) {
    // nothing to implement    
    }

    @Override
    public List<Empleado> getEmployees() {
    // nothing to implement
     return null;
    }

    @Override
    public int calculatePoints() {
        return new Random().nextInt(24);
    }

    @Override
    public String toString() {
        return "I am " + getName() + ", Developer";
    }

}