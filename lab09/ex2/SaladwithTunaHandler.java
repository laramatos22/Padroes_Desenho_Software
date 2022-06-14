package ex2;

public class SaladwithTunaHandler extends Handler {

    public void handlePedido(String pedido) {
        if (pedido.equals("Salad with Tuna")) 
            System.out.println("We're sorry but that request can't be satisfied by our service!");       
    }
}
