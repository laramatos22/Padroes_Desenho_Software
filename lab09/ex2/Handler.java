package ex2;

public abstract class Handler {
    Handler sucessor;
    public Handler setSucessor(Handler sucessor) {
       this.sucessor = sucessor;
       return this;
    }
    public abstract void handlePedido(String pedido);
}