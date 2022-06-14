package ex2;

public class SushiHandler extends Handler {

    public void handlePedido(String pedido) {
        if (pedido.equals("Sushi nigiri and sashimi")) 
            System.out.println("SushiChef: Starting to cook sushi nigiri and sashimi. Out in 14 minutes!");
        else {
            System.out.println("SushiChef: I can't cook that.");
            if (sucessor != null) 
                sucessor.handlePedido(pedido);
        }
    }    
}
