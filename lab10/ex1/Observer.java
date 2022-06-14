package ex1;

import java.util.ArrayList;

public abstract class Observer {
    protected ArrayList<Produto> prodList;
    private String name;

    public Observer(String name){
        this.name=name;
        prodList= new ArrayList<Produto>();
    }

    public abstract void update(Produto p);

    public void getNotifications(Produto p){
        p.attach(this);
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    @Override
    public String toString(){
        return name;
    }
}
