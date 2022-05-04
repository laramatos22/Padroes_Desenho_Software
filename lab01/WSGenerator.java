package lab01;

// Escreva o programa WSGenerator, que crie uma Sopa de Letras de acordo com o
// formato e requisitos anteriores. O programa deve receber como parâmetro de entrada
// um ficheiro com a lista de palavras, a dimensão da sopa de letras e o nome de um
// ficheiro para guardar a Sopa de Letras.

import java.io.*;
import java.util.*;

public class WSGenerator {

    public boolean writeToFile(String name, char[][] initial_soup, ArrayList<String> words) {

        try {
            FileWriter writer = new FileWriter("lab01/"+name);
            PrintWriter printWriter = new PrintWriter(writer);

            for (int i = 0; i < initial_soup.length; i++) {
                StringBuilder lineBuilder = new StringBuilder();

                for (int j = 0; j < initial_soup.length; j++) 
                    lineBuilder.append(initial_soup[i][j]);
                printWriter.println(lineBuilder.toString());
            }

            StringBuilder wordLineBuilder = new StringBuilder();

            int counter = 0;

            for (String word : words) {
                counter++;
                if(counter == words.size())
                    wordLineBuilder.append(word);
                else    
                    wordLineBuilder.append(word + ", ");
            }
            printWriter.print(wordLineBuilder.toString());

            printWriter.close();
            writer.close();

        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public ArrayList<String> readWords (File wordFile) throws FileNotFoundException {

        Scanner scf = new Scanner (wordFile);
        ArrayList<String> words = new ArrayList<>();

        while (scf.hasNextLine()) {
            String currentLine = scf.nextLine();

            String[] currentWords = currentLine.split("[,; ]");
            for (int i = 0; i < currentWords.length; i++) {
                if(currentWords[i].length()<3 || currentWords[i].length()>40)
                    continue;
            }
        }
        if (words.size()>(40*40)){
            System.out.println("ERROR: respect size, 40*40");
            System.exit(1);
        }
        for(int i = 0 ; i < words.size() ; i++){
            for(int j = i+1 ; j<words.size() ; j++){
                if(words.get(i).contains(words.get(j)) || words.get(j).contains(words.get(i))){
                    System.out.println("ERROR: Word list contains duplicate or redundant words");
                    System.exit(1);
                }
            }
        }
        return words;
    }

    //----------------------------------------

    public char[][] createS(ArrayList<String> wordList){
        String largestWord = wordList.get(0);
        Random randomGen = new Random();

        for(int i = 1 ; i<wordList.size() ; i++){
            if(largestWord.length()<wordList.get(i).length())
                largestWord = wordList.get(i);
        }

        int minSize =  largestWord.length()>Math.ceil(Math.sqrt(wordList.size())) ? largestWord.length() : (int) Math.ceil(Math.sqrt(wordList.size()));
        minSize = minSize>10 ? minSize : 10;
        int s = randomGen.nextInt(61-minSize) + minSize;

        char[][] sopa = new char[s][s];
        for(int i = 0 ; i<s ; i++)
            for(int j = 0 ; j<s ; j++)
                sopa[i][j] = (char)(randomGen.nextInt(91-65)+65);

        ArrayList<Integer[]> occupiedPositions = new ArrayList<>();

        for(String word : wordList){
            ArrayList<Integer[]> tempArray = getInsertPositions(word,sopa,occupiedPositions);
            for(int i = 0 ; i<tempArray.size() ; i++) {
                int posX = tempArray.get(i)[0];
                int posY = tempArray.get(i)[1];

                sopa[posX][posY] = word.toUpperCase().charAt(i);
            }
            occupiedPositions.addAll(tempArray);
        }
        return sopa;
    }

    //----------------------------------------

    private  ArrayList<Integer[]> getInsertPositions(String word,char[][]sopa, ArrayList<Integer[]> occupiedPositions){
        int tryCounter=0;
        Random randomGen = new Random();

        while(tryCounter < 500){
            boolean contador = false;

            Direction currentDirection = Direction.getRandomDirection();
            int sopaSize = sopa.length;

            int x = randomGen.nextInt(sopaSize-0) + 0,y = randomGen.nextInt(sopaSize-0) + 0;
            
            ArrayList<Integer[]> occupiedPosArray = new ArrayList<>();
            for(int i = 0 ; i<word.length() ; i++){
                Integer[] currentPosition = {x,y};

                char currentChar = word.charAt(i);
                if(currentPosition[0]>=sopaSize || currentPosition[1]>=sopaSize || currentPosition[0]<0 || currentPosition[1]<0) {
                    contador = true;
                    break;
                }

                for(Integer[] pos : occupiedPositions)
                    if(pos[0]==currentPosition[0] && pos[1]==currentPosition[1])
                        if(currentChar!=sopa[currentPosition[0]][currentPosition[1]]){
                            contador = true;
                            break;
                        }

                occupiedPosArray.add(currentPosition);

                switch (currentDirection){ //igual ao WSSolver mas escrito de forma diferente
                    case UP:
                        y++;
                        break;
                    case DOWN:
                        y--;
                        break;
                    case LEFT:
                        x--;
                        break;
                    case RIGHT:
                        x++;
                        break;
                    case UPLEFT:
                        x--;
                        y--;
                        break;
                    case UPRIGHT:
                        x++;
                        y--;
                        break;
                    case DOWNLEFT:
                        x--;
                        y++;
                        break;
                    case DOWNRIGHT:
                        x++;
                        y++;
                        break;
                }

            }

            if(contador){
                tryCounter++;
                continue;
            }

            return occupiedPosArray;
        }

        return null;
    }
}
