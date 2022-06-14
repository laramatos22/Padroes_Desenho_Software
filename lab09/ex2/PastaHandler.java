package ex2;

public class PastaHandler extends Handler {

    public void handlePedido(String pedido) {
        if (pedido.equals("Pasta Carbonara")) 
            System.out.println("PastaChef: Starting to cook Pasta Carbonara. Out in 14 minutes!");
        else {
            System.out.println("PastaChef: I can't cook that.");
            if (sucessor != null) 
                sucessor.handlePedido(pedido);
        }
    }
}
