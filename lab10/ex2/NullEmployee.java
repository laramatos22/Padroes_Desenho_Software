package ex2;

/**
 * Diogo Mendes - 88801
 * Lara Matos - 95228
 */

public class NullEmployee extends Employee {

    public NullEmployee(String name) { this.name = name; }

    public String getName() {
        return ("ERROR: " + name + " does not exist!");
    }

}