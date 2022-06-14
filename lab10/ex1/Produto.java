package ex1;

import java.util.ArrayList;
import java.util.List;

public class Produto{
    private static int counter=0;
    private int id;
    private String description;
    private double price;
    private State state;

    private List<Observer> observers = new ArrayList<Observer>();
    private Observer atual; //cliente com a bid mais alta

    public Produto(String description, double price){
        this.id=counter++;
        this.description=description;
        this.price=price;
        state=State.STOCK;
    }

    public void attach(Observer o){
        if(observers.contains(o)); //se já está na lista não faz nada
        else observers.add(o);
    }
    public void remove(Observer o){
        if(observers.contains(o)) observers.remove(o);
    }
    public void removeAll(){
        observers.clear();
        //observers= new ArrayList<Observer>();
    }
    
    private void notifyObservers(){ //saber se à nova bid ou nao, se nao houver é porque é mudanca de estado
        for (Observer obs :observers){
            obs.update(this);
        }
    }
    public boolean bid(Observer obs, double p){
        attach(obs);
        if(p>price && state.equals(State.AUCTION)) {
            atual=obs;
            setPrice(p);
            return true;
        }
        return false;
    }

    //Gets and Sets
    public int getID(){
        return id;
    }

    public double getPrice(){
        return price;
    }
    public State getState(){
        return state;
    }
    public Observer getAtual(){
        return atual;
    }

    public void setPrice(double p){ //mudança de preço = new bid
        this.price=p;
        notifyObservers();
    }
    public void setState(State s){ //mudança de estado, logo new bid é falsa
        this.state=s;
        notifyObservers();
    }


    @Override
    public String toString(){
        if(atual==null) return "Prod. with ID: "+id+", costs "+price+" and is on "+state+", current highest bidder not available";
        return "Prod. with ID: "+id+", costs "+price+" and is on "+state+", current highest bidder "+atual.toString();
    }
}