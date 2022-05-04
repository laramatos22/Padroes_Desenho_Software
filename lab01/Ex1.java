package lab01;

import java.io.*;
import java.util.*;

public class Ex1 {

    public static void main(String[] args) throws FileNotFoundException {
        
        try{
            if(args.length!=1 ) throw new Exception();  
        }
        catch(Exception e){
            System.out.println("The correct grammar for this program is: java WSSolver filename ");
        };

        File soup_file = new File(args[0]);
        Scanner scf = new Scanner(soup_file);

        try {
            int soup_size = scf.nextLine().length();
            scf.close();

            if (soup_size > 40) {                // O puzzle é sempre quadrado, com o tamanho máximo de 40x40.
                System.err.println("ERROR! Soup can't be bigger than 40x40");
                System.exit(1);
            }
            
            WSSolver solver = new WSSolver();
            List<String> words = solver.getWordList(soup_file, soup_size);

            int contador =0; //test for duplicates or redudants
            for (int i = 0; i < words.size()-1; i++) {
                for (int j = 1; j < words.size(); j++) {
                    if (words.get(i).equals(words.get(j))) {
                        contador++;
                        if(contador==2){
                            System.out.println("ERROR: Word list contains duplicate or redundant words");
                            System.exit(1);
                        }
                    }
                }
                contador=0;
            }

            char[][] soup = solver.getSoupList(soup_file, soup_size);

            for (String word : words) {
                word = word.toUpperCase();
                String[] returnValues = solver.findWord(soup, word);
                System.out.printf("%-10s %-5d %-4s %s\n", word, word.length(), returnValues[0], returnValues[1]);
            }

        } catch (Exception e) {
            System.err.format("ERROR! %s can't be read", soup_file);
            System.exit(1);
        }

    }
    
}
