package ex3;

/**
 * Diogo Mendes - 88801
 * Lara Matos - 95228
 */

public class MediatorDemo {

    public static void main (String[] args) {

        Mediator chatRoom = new MessengerImpl();

        ConcretePerson p1 = new ConcretePerson("Diogo", chatRoom);
        p1.getName();
        p1.sendMessage("Hi Lara! How are you?");

        ConcretePerson p2 = new ConcretePerson("Lara", chatRoom);
        p2.getName();
        p2.sendMessage("Hey Diogo! I'm fine, thanks!");

    }
    
}
