package FactoryMethod.Second_Example;

public class Limoeiro implements Arvore {

    protected Limoeiro() {
        System.out.println("Limoeiro plantado.");
    }

    public void regar() {
        System.out.println("Limoeiro: Regar pouco");
    }

    public void colherFruta() {
        System.out.println("Humm.. caipirinha!");
    }
    
}
