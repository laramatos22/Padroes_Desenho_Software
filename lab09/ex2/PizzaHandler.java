package ex2;

public class PizzaHandler extends Handler {

    public void handlePedido(String pedido) {
        if (pedido.equals("Pasta Carbonara")) 
            System.out.println("PizzaChef: Starting to cook PLAIN pizza, no toppings!. Out in 7 minutes!");
        else {
            System.out.println("PizzaChef: I can't cook that.");
            if (sucessor != null) 
                sucessor.handlePedido(pedido);
        }
    }
}
