package ex3;

import java.util.ArrayList;
import java.util.List;

public class Caixa extends Alimento {

    private List<Alimento> list_alimentos = new ArrayList<>();
    private String name;
    private double weight;
    private double totalWeight = 0;

    public Caixa(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {return name;}
    public double getWeight() {return weight;}

    public void add(Alimento al) {
        list_alimentos.add(al);
    }

    @Override
    public void print() {
        System.out.println(string_buffer.toString() + "* Caixa '" + name + "' [ Weight: " + weight + " Total Weight: " + (getTotalWeight() + weight) + "]");
        string_buffer.append("   ");

        for (int i = 0; i < list_alimentos.size(); i++){
            list_alimentos.get(i).print();
        }
        string_buffer.setLength(string_buffer.length() - 3);

    }

    private double getTotalWeight() {
        for (int i = 0; i < list_alimentos.size(); i++) 
            totalWeight += list_alimentos.get(i).getWeight();
        return totalWeight;
    }
}
