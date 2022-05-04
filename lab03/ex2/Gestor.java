package ex2;

import java.util.*;
import java.io.*;

public class Gestor {
    private String option;
    private String[] args;
    private LinkedList<Voo> voos;

    public Gestor() throws FileNotFoundException {
        menu(); // start running menu
    }

    private void menu() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        option = "A";

        // initiate menu cycle until Q is chosen
        while (!option.equals("Q")) {
            System.out.println("Escolha uma opção: (H para ajuda)\n");
            try {
                String temp = sc.nextLine();
                args = temp.split(" ");
                if (args.length > 4)
                    throw new Exception();
                if (!checkArg(args[0]))
                    throw new Exception();
                option = args[0];
            } catch (Exception e) {
                errorOption();
            }

            // Call each function according to option chosen
            switch (option) {
                case "Q":
                    System.out.println("Adeus");
                    System.exit(1);
                    break;

                case "H":
                    helpGuide();
                    break;

                case "I":
                    while(readFile(args[1])); //Enquanto o file der erro entao restart no ciclo
                    break;
                
                case "M":
                    printVooReservas(args[1]);
                    break;
                
                case "F":
                    if(args.length==3 )addSeats(args[1],args[2]); 
                    else if(args.length==4 )addSeats(args[1],args[2],args[3]); 
                    else System.out.println("Introduza flightcode class numberofseats");
                    break;
                
                case "R":
                    if(args.length==4) addReserva(args[1], args[2], args[3]);
                    else System.out.println("Introduza flightcode class numberofseats");
                    break;
                
                case "C":
                if(args.length>2) System.out.println("Introduza apenas reservation_code (flightcode:seq_res_number)");
                else cancelaReserva(args[1]);
                break;

                default:
                System.out.println("Opção não encontrada! Cuidado que o sistema é case sensitive");
                System.out.println("Insira H para aceder ao menu de ajuda");
            }
        }

        sc.close();
    }

    // ----- Functions pela ordem usada no switch case-----

    public void helpGuide() {
        System.out.println(
                "\nPara utilizar este programa deve introduzir a letra da opção que pretende e um argumento caso seja necessario");
        System.out.println("Note que o sistema é sensível a maiúsculas.");
        System.out.println("Exemplo: M TP1920 ");
        System.out.println("");
        System.out.println("Lista de opções:");
        System.out.println("H - apresenta este menu de ajuda");
        System.out.println("I filename - ler um ficheiro com informação sobre um voo.");
        System.out.println("M flight_code - exibir o mapa de reservas de um voo.");
        System.out.println(
                "E flight_code num_seats_executive num_seats_tourist - acrescenta um novo voo com o codigo, lugares em executiva e lugares em turistica");
        System.out.println(
                "R flight_code class number_seats - acrescenta reserva a um voo, da classe (T/E) e numero de lugares");
        System.out.println("C reservation_code - cancela uma reserva");
        System.out.println("Q - termina o programa");
        System.out.println("");
    }

    public boolean readFile(String input){
        File inputFile = new File(input);
        try{
            Scanner scf = new Scanner(inputFile);
            String tmp=scf.nextLine();
            String[] primeiralinha = tmp.split(" ");
            if(!testeChar(primeiralinha[0]));
            Voo v;
            if(primeiralinha.length==2) v = new Voo(nomeVoo(primeiralinha[0]),primeiralinha[1]);
            else v = new Voo(nomeVoo(primeiralinha[0]),primeiralinha[1],primeiralinha[2]);
            v.toString();
            while(scf.hasNextLine()){
                String read =scf.nextLine();
                String[] linha = read.split(" ");
                Reserva reserva = new Reserva(linha[0],Integer.parseInt(linha[1]));
                v.addReserva(reserva);
            }
            voos.add(v);
            scf.close();
        }
        catch(Exception E){
            System.out.println("Error: File not Found! or File construction not adequate!");
            System.out.println("Please make sure that the file starts with '>' ");
            return false;
        }
        return true;
    }
    public void printVooReservas(String id){
        findVoo(id).printReservas();
    }

    public void addSeats(String name, String tur){
        Voo voo = new Voo(name, tur);
        voos.add(voo);
    }
    public void addSeats(String name, String exec, String tur){
        Voo voo = new Voo(name, exec, tur);
        voos.add(voo);
    }

    public void addReserva(String name, String classe, String nlug){
        Reserva reserva = new Reserva(classe, Integer.parseInt(nlug));
        findVoo(name).addReserva(reserva);
        System.out.println(name+":"+reserva.getID()+" = "+nlug);
    }

    private Voo findVoo(String id){
        for(int i=0;i<voos.size(); i++){
            if(id.equals(voos.get(i).getID())){
                return voos.get(i);
            }
        }
        System.out.println("Código de Voo não encontrado");
        return null;
    }

    public void cancelaReserva(String input){
        String[] str = input.split(":");
        String nome = str[0];
        String code = str[1];
        findVoo(nome).cancelaR(Integer.parseInt(code));
    }
    // ------ Checks and prints -----

    // Checks if the argument letter is valid
    private boolean checkArg(String arg) {
        if (arg.equals("I") || arg.equals("H") || arg.equals("M") || arg.equals("F") || arg.equals("R")
                || arg.equals("C") || arg.equals("Q"))
            return true;
        return false;
    }

    private boolean testeChar(String str){
        char[] ch = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            ch[i] = str.charAt(i);
        }
        if(ch[0]=='>')return true;
        return false;
    }

    private String nomeVoo(String str){
        String r ="";
        for (int i = 1; i < str.length(); i++) {
            r = r + str.charAt(i);
        }
        return r;
    }

    private void errorOption() {
        System.out.println("Opção tem seguir o formato adequado, insira H para ajuda\n");
        option = "next";
    }
}
