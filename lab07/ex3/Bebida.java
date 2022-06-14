package ex3;

public class Bebida extends Alimento {

    private String name;
    private double weight;

    public Bebida (String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public double getWeight() {return weight;}

    @Override
    public void print() {
        System.out.println(string_buffer.toString() + "Bebida '" + name + "' - Weight : " + weight);
    }

    
}
