package FactoryMethod.Second_Example;

public class Viveiro {

    public static Arvore factory(String pedido) {
        if (pedido.equalsIgnoreCase("Figueira"))
            return new Figueira();

        if (pedido.equalsIgnoreCase("Pessegueiro"))
            return new Pessegueiro();

        if (pedido.equalsIgnoreCase("Limoeiro"))
            return new Limoeiro();

        else
            throw new IllegalArgumentException(pedido + "não existente");
    }
    
}
