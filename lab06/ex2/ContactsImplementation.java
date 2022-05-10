package ex2;

import java.util.*;

public class ContactsImplementation implements ContactsInterface {
    
    protected List<Contact> contacts;
    protected ContactsStorageInterface storage;

    public ContactsImplementation () {
        this.contacts = new ArrayList<>();
    }

    public void openAndLoad(ContactsStorageInterface storage) {
        this.storage = storage;
        this.contacts.addAll(storage.loadContacts());
        System.out.println("Loading Contacts...");
        for (Contact contact : contacts) 
            System.out.println(contact);
    }

    public void saveAndClose() {
        boolean st = this.storage.saveContacts(this.contacts);
        if (st == true)
            System.out.println("Saved");
        else
            System.out.println("Not Saved");
    }

    public void saveAndClose(ContactsStorageInterface storage) {
        boolean st = storage.saveContacts(this.contacts);
        if (st == true)
            System.out.println("Saved");
        else
            System.out.println("Not Saved");
    }

    public boolean exist(Contact contact) {
        for (Contact cont : contacts) {
            if (cont.toString().equals(contacts.toString()))
                return true;
        }
        return false;
    }

    public Contact getByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(name))
                return contact;
        }
        System.out.println("Contact Not Found!");
        return null;
    }

    public boolean add(Contact contact) {
        return contacts.add(contact);
    }

    public boolean remove(Contact contact) {
        return contacts.remove(contact);
    }
}
