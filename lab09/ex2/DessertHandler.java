package ex2;

public class DessertHandler extends Handler {

    public void handlePedido(String pedido) {
        if (pedido.equals("Strawberry ice cream and waffles dessert")) 
            System.out.println("DessertChef: Starting to cook strawberry ice cream and waffles dessert. Out in 17 minutes!");
        else {
            System.out.println("DessertChef: I can't cook that.");
            if (sucessor != null)
                sucessor.handlePedido(pedido);
        }
    }
}
