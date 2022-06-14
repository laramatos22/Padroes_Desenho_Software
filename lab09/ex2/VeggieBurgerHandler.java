package ex2;

public class VeggieBurgerHandler extends Handler {

    public void handlePedido(String pedido) {
        if (pedido.equals("Veggie Burger"))
            System.out.println("BurgerChef: Starting to cook veggie burger. Out in 19 minutes!");
        else {
            System.out.println("BurgerChef: I can't do that.");
            if (sucessor != null)
                sucessor.handlePedido(pedido);
        }
    }
}
