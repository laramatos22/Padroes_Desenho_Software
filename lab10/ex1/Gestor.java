package ex1;

import java.util.Hashtable;

public class Gestor extends Observer{
    //dicionario para guardar produto - estado
    //isto serve para no update verificar se houve alteração de estado
    //e só notificar o gestor se realmente houver alteração de estado
    Hashtable<Produto,State> estados = new Hashtable<Produto,State>();
    
    public Gestor(String name){
        super(name);
        initializaStates(); //introduzir valores no dicionario
    }

    public void getNotifications(Produto p){
        p.attach(this); //Observer register themselves
    }
    public void startAuction(Produto p, int time){
        getNotifications(p);
        p.setState(State.AUCTION);
    }
    public void goSales(Produto p){
        p.setState(State.SALES);
    }
    public void goStock(Produto p){
        p.setState(State.STOCK);
    }
    public void endAuction(Produto p){
        if(p.getAtual()==null) goStock(p);
        else goSales(p);
        p.removeAll();

    }
    private void initializaStates(){
        for(Produto p : prodList){
            estados.put(p, p.getState());
        }
    }

    //So notifica quando há mudança de estado
    public void update(Produto p) {
        if(!p.getState().equals(estados.get(p))){
            System.out.println(this.getName()+": Product "+p.getID()+" has changed state to "+p.getState());
            estados.put(p,p.getState()); //update state on the dictionary
        } 
    }
}
