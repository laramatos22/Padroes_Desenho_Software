package Padroes_Estruturais.Composite.Second_Example;

public class Product extends Entity {

    private int value;

    public Product(int val) {
        value = val;
    }

    public void traverse() {
        System.out.println(indent.toString() + value);
    }
    
}
