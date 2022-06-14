package ex2;

// Nomes: Diogo Mendes e Lara Matos;
// Grupo: 503

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main (String[] args) {

        List<String> List = new ArrayList<>();
        List.add("Veggie Burger");
        List.add("Pasta Carbonara");
        List.add("PLAIN Pizza, no toppings");
        List.add("Sushi nigiri and sashimi");
        List.add("Salad with Tuna");
        List.add("Strawberry ice cream and waffles dessert");

        System.out.println("Can I please get a veggie burger?");
            Handler handler = new SushiHandler().setSucessor(
                                new PastaHandler().setSucessor(
                                    new VeggieBurgerHandler().setSucessor(
                                        new PizzaHandler().setSucessor(
                                            new DessertHandler()))));  

        for (String str : List) {
            handler.handlePedido(str);
            System.out.println("\n");
        }
    }  
}
