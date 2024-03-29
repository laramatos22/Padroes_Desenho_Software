package ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactsStorageTxt implements ContactsStorageInterface {

    private String fileName;

    public ContactsStorageTxt (String fileName){
        this.fileName = fileName;
    }

    public List<Contact> loadContacts(){
        List<Contact> contactsList = new ArrayList<>();

        try{
            Path filePath = Paths.get(this.fileName);
            Scanner reader = new Scanner(new File(filePath.toString()));

            while (reader.hasNextLine()){
                String line = reader.nextLine();
                String[] data = line.split("\t");
                contactsList.add(new Contact(data[0], Integer.parseInt(data[1])));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Occur an error -> File Not Found");
        }
        return contactsList;
    }
    public boolean saveContacts(List<Contact> list){

        String data = "";
        for (Contact contact : list)
            data = data + contact.getName() + "\t" + contact.getNum() + "\n";

        try {
            Path filePath = Paths.get(this.fileName);
            FileWriter writer = new FileWriter(filePath.toString());
            writer.write(data);
            writer.close();

        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
