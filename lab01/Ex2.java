package lab01;

import java.util.ArrayList;

import java.io.*;
import java.util.*;

public class Ex2 {

    public static void main(String[] args) throws IOException{

        String inputfile;
        String outputfile;
        int size;

        // try {
        //     arg = 0;
        //     while (arg<args.length) {
        //         if(args[arg].equals("-i")) {
        //                 if(args.length > arg+1) {
        //                         inputfile="lab01/"+args[arg+1];
        //                         arg += 2;
        //                 }
        //         }
        //         else if(args[arg].equals("-s")) {
        //                 if(args.length > arg+1) {
        //                     size=args[arg+1];
        //                     arg += 2;
        //                 }
        //         }
        //         else if(args[arg].equals("-o")) {
        //                 if(args.length > arg+1) {
        //                         outputfile="lab01/"+args[arg+1];
        //                         arg += 2;
        //                 }
        //         }
        //         else throw new Exception();
        //     }
        // }
        // catch (Exception e) {
        //         print_usage();
        //         return;
        // }
        inputfile="words1.txt";
        size=40;
        outputfile="sdl02_txt";
        

        try {
            File ifile = new File(inputfile);
            Scanner scf = new Scanner (ifile);
            WSGenerator generator = new WSGenerator();
            ArrayList<Integer[]> currentPositions = new ArrayList<>();
            ArrayList<Integer[]> occupiedPositions = new ArrayList<>();
            ArrayList<String>wordList = generator.readWords(ifile);
            char[][] sopa = generator.createS(wordList);

            for (int i = 0; i < sopa.length; i++) {
                for (int j = 0; j < sopa.length; j++) {
                    System.out.println(sopa[i][j]);
                }
                System.out.println();
            }
            generator.writeToFile(inputfile,sopa,wordList);
        } catch (FileNotFoundException e) {
            file_error();
            System.exit(1);
        }
    }

    static void file_error(){
        System.err.println("ERROR! File Not Found");
    }

    static void print_usage() {
        System.err.println("Usage: java Ex2 [-i <wordlist_file>] [-s <size>] [-o <output_file>]");
    }
}
