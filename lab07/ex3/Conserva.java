package ex3;

public class Conserva extends Alimento {

    private String name;
    private double weight;

    public double getWeight() {return weight;}

    public Conserva (String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public void print() {
        System.out.println(string_buffer.toString() + "Conserva '" + name + "' - Weight : " + weight);
    }

}
