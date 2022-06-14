package ex1;

public class Cliente extends Observer{

    public Cliente(String name){
        super(name);
    }

    public void checkProducts(){
        for (Produto p : prodList){
            if(p.getState().equals(State.AUCTION)) System.out.println(p.toString());
        }
    }

    public void bid(Produto p, double price){
        if(p.bid(this,price));
        else System.out.println("Bid from "+ this.getName() +" was not high enough or product is not for auction");
    }

    public void update(Produto p) {
        System.out.println(this.getName()+": "+p.toString());
    }
    
}
