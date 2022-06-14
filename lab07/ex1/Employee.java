package ex1;

import java.util.*;

class Employee implements EmployeeInterface {
    private String name;

    public Employee(String name) {this.name = name;}

    @Override
    public void start(Date date) {
        System.out.println("\n" + name + " started on " + date.toString());
    }

    @Override
    public void terminate(Date date) {
        System.out.println("\n" + name + " terminated on " + date.toString());
    }

    @Override
    public void work() {
        System.out.println("\n" + name + " is working!");
    }

    public String name() {return name;}
}
