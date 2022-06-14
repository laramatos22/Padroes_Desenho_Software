package ex3;

/**
 * Diogo Mendes - 88801
 * Lara Matos - 95228
 */

import java.util.ArrayList;

public class MessengerImpl implements Mediator {

    private ArrayList<Person> colleagues;

    public MessengerImpl() {
        colleagues = new ArrayList<Person>();
    }

    public void addPerson (Person colleague) {
        colleagues.add(colleague);
    }

    public void sendMessage(String msg, Person p) {
        for (Person person : colleagues) {
            if (person != p)
                person.receive(msg);
        }
    }

    public void showMessage(String msg, Person colleague) {
        System.out.println(colleague.getName() + "gets message " + msg);
    }
    
}
