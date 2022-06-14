package ex3;

/**
 * Diogo Mendes - 88801
 * Lara Matos - 95228
 */

public abstract class Person {

    private Mediator mediator;

    public Person (Mediator m) {
        mediator = m;
    }

    public void sendMessage(String msg) {
        mediator.sendMessage(msg, this);
    }

    public abstract String getName();
    public abstract void setName(String name);
    public abstract void receive(String msg);
    
}
