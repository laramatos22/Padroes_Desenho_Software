package ex3;

public class Doce extends Alimento {

    private String name;
    private double weight;

    public double getWeight() {return weight;}

    public Doce (String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public void print() {
        System.out.println(string_buffer.toString() + "Doce '" + name + "' - Weight : " + weight);
    }
    
}
