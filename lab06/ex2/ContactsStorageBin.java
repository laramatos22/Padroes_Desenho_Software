package ex2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ContactsStorageBin implements ContactsStorageInterface {
    
    private String fileName;

    public ContactsStorageBin(String fileName) {
        this.fileName = fileName;
    }

    public List<Contact> loadContacts() {

        List<Contact> contactsList = new ArrayList<>();

        try {
            Path filePath = Paths.get(this.fileName);
            BufferedReader reader = new BufferedReader(new FileReader(filePath.toString()));
            String line = reader.readLine();

            while (line != null) {
                String[] contactInfo = line.split("\t");
                Contact cont = new Contact(contactInfo[0], Integer.parseInt(contactInfo[1]));
                contactsList.add(cont);
                line = reader.readLine();
            }

            reader.close();
        } catch (Exception e) {
            System.err.println("Occure an error -> File Not Found");
        }
        return contactsList;
    }

    public boolean saveContacts(List<Contact> list) {

        try {
            Path filePath = Paths.get(this.fileName);
            BufferedWriter bwriter = new BufferedWriter(new FileWriter(filePath.toString()));

            for (Contact c : list) 
                bwriter.write(c.toString() + "\n");
            bwriter.close();
            
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
