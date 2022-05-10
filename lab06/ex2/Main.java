package ex2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main (String[] args) {

        try {
            File contactsFile = new File ("ex2/contacts.txt");
            contactsFile.createNewFile();

            FileWriter fileWriter = new FileWriter(contactsFile.toString());
            fileWriter.write("Antonio\t965432860\n");
            fileWriter.write("Francisco\t932735903\n");
            fileWriter.write("Felisberto\t910345130\n");
            fileWriter.write("Antonieta\t903647091\n");
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("Error -> IOException");
        }

        ContactsStorageTxt contactsTxt = new ContactsStorageTxt("ex2/contacts.txt");
        ContactsImplementation contactsImp = new ContactsImplementation();
        contactsImp.openAndLoad(contactsTxt);

        Contact cont1 = new Contact("Silvina", 987654321);
        contactsImp.add(cont1);
        contactsImp.add(new Contact("Bernardo", 123456789));

        contactsImp.remove(cont1);
        contactsImp.remove(contactsImp.getByName("Francisco"));

        System.out.println("Antonieta pertence aos seus contactos?");
        boolean resp1 = contactsImp.exist(contactsImp.getByName("Antonieta"));
        System.out.println(resp1);

        System.out.println("Silvina pertence aos seus contactos?");
        boolean resp2 = contactsImp.exist(cont1);
        System.out.println(resp2);

        contactsImp.saveAndClose();

        try {
            File newFile = new File ("ex2/newContacts.txt");
            newFile.createNewFile();
        } catch (IOException e) {
            System.out.println("Error -> IOException");
        }

        ContactsStorageTxt contactsTxt2 = new ContactsStorageTxt("ex2/newContacts.txt");
        contactsImp.saveAndClose(contactsTxt2);
        ContactsImplementation contactsImp2 = new ContactsImplementation();
        contactsImp2.openAndLoad(contactsTxt2);

    }
    
}
