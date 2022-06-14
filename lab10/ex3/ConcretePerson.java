package ex3;

/**
 * Diogo Mendes - 88801
 * Lara Matos - 95228
 */

public class ConcretePerson extends Person {

    private String name;
    private Mediator mediator;

    public ConcretePerson(String name, Mediator mediator) {
        super(mediator);
        this.name = name;
    }

    public void sendMessage(String msg) {
        mediator.sendMessage(msg, this);
    }

    public void setName(String name) { this.name = name; }
    public String getName() { return name; }

    public void receive(String msg) {
        System.out.println("Person received: " + msg);
    }
    
}
