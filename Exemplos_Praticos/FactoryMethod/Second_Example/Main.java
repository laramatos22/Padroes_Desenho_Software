package FactoryMethod.Second_Example;

public class Main {

    public static void main (String[] args) {
        Arvore pomar[] = {
            Viveiro.factory("Figueira"),
            Viveiro.factory("Pessegueiro"),
            Viveiro.factory("Limoeiro")
        };

        for (Arvore arvore : pomar) {
            arvore.regar();
        }

        for (Arvore arvore : pomar) {
            arvore.colherFruta();
        }
    }
    
}
