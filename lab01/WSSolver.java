package lab01;

import Direction.java;
import java.util.*;
import java.io.*;

// WORD SEARCH SOLVER
// A lista de palavras do puzzle retornadas pelo WSSolver tem de estar na mesma ordem
// das palavras passadas na lista. As palavras têm de estar em maiúsculas.

public class WSSolver {

    public ArrayList<String> getWordList(File soup_file, int soup_size) throws FileNotFoundException {
        Scanner scf = new Scanner(soup_file);

        ArrayList<String> words = new ArrayList<>();

        for (int i = 0; i < soup_size; i++) 
            scf.nextLine();
        
        while (scf.hasNextLine()) {
            String line = scf.nextLine();

            String[] currentWords = line.split("[,; ]");

            for (int i = 0; i < currentWords.length; i++) {
                if (currentWords[i].length() < 3) {
                    continue;
                }
                boolean ignoreWord = false;

                // j is like a test char to see if is a alphabetical character or not
                for (int j = 0; j < currentWords[i].length(); j++) {
                    if (!Character.isAlphabetic(currentWords[i].charAt(j))) {
                        System.err.format("ERROR! %s is a non alphabetical character so the word %s will be ignored", j, currentWords[i]);
                        ignoreWord = true;
                        break;
                    }
                }
                if (!ignoreWord) {
                    words.add(currentWords[i]);
                }
            }
        }

        scf.close();
        return words;

    }

    public char[][] getSoupList (File soup_file, int soup_size) throws FileNotFoundException {
        Scanner scf = new Scanner(soup_file);
        char[][] soup = new char [soup_size][soup_size];

        for (int i = 0; i < soup_size; i++) {
            String line = scf.nextLine();
            for (int j = 0; j < soup_size; j++) {
                soup[i][j] = line.charAt(j);
            }
        }

        scf.close();
        return soup;

    }

    public String[] findWord(char[][] soup, String word) {
        int soup_size = soup.length;
        word = word.toUpperCase();

        //String[] returnValues = new String[2];
        int direction = -1;

        for (int i = 0; i < soup_size; i++) {
            for (int j = 0; j < soup_size; j++) {
                if (soup[i][j] == word.charAt(0)) {
                    direction = checkAllDirections(soup, word, i, j);
                    if(direction!=-1)
                        return new String[]{++i + "," + ++j, Direction.values()[direction].toString()};
                }
            }
        }

        System.err.format("ERROR! Word %s not found\n", word);
        System.exit(1);
        return null;
    }

        private int checkAllDirections (char[][] soup, String word, int y, int x) {
            int[] xDirections = {  0,  0,-1, 1, -1, -1,  1, 1}; //In order: UP DOWN LEFT RIGHT UPLEFT DOWNLEFT UPRIGHT DOWNRIGHT
            int[] yDirections = { -1,  1, 0, 0, -1,  1, -1, 1}; //In order: UP DOWN LEFT RIGHT UPLEFT DOWNLEFT UPRIGHT DOWNRIGHT
            for (int i = 0; i < yDirections.length; i++) { //verify the 8 possible directions
                int charCounter;
                int nextX = x + xDirections[i];
                int nextY = y + yDirections[i];

                for (charCounter = 1; charCounter < word.length(); charCounter++) {
                    // If out of bound
                    if (nextX >= soup.length || nextX < 0 || nextY >= soup.length || nextY < 0)
                        break;

                    // If not matched
                    if (soup[nextY][nextX] != word.charAt(charCounter))
                        break;

                    //Continue moving
                    nextX += xDirections[i];
                    nextY += yDirections[i];
                }

                if (charCounter == word.length())
                    return i;
            }

            return -1;

        }
    
}
