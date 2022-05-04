import java.io.*;
import java.util.*;

import javax.swing.text.PlainView;

//import lab03.Plane;
//import lab03.Voo;


public class ex2 {
    
    public static FileWriter outputFile; // Output File
    public static ArrayList<Voo> voos = new ArrayList<>(); //lista com todos os voos

    public static void main(String[] args) throws IOException {
        String[] aux = {};
        

        System.out.println("Escolha uma opcao: (H para ajuda)");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        char x = text.charAt(0);

        while(x != 'Q'){
            switch(x){
                case 'H':
                    System.out.println("--------------------- HELP ---------------------\nH - apresenta opcoes do menu\nI <filename> - Le info sobre um voo\nM <flight_code> - exibe mapa de reservas no voo com esse codigo\nF <flight_code> <num_seats_exec> <num_seats_tourist> - novo voo com codigo e lugares em executiva e turistica\nR <flight_code> <class> <number_seats> - acrescenta nova reserva no voo\nC <flight_code:sequential_reservation_number> - cancela uma reserva\nQ - termina programa\n------------------------------------------------");
                    break;
                case 'I':
                    aux = text.split(" ");
                    //readFile(aux[1]);
                    try {
                        readFile(aux[1]);
                    } catch (Exception e) {
                        System.out.println("!!! Invalid file - check spelling and location !!!");
                    }
                    break;
                case 'M':
                    aux = text.split(" ");
                    for(int i= 0; i<voos.size();i++){
                        if(voos.get(i).getCode().equals(aux[1])){
                            System.out.println(voos.get(i).getPlane().getMap());
                            break;
                        }
                    }
                    break;
                case 'F':
                    createFlight(text);
                    break;
                case 'R':
                    break;
                case 'C':
                    break;
                case 'Q':
                    break;
                default:
                    System.out.println("Invlid input");
                    break;
            }
            System.out.println("\nEscolha uma opcao: (H para ajuda)");
            text = sc.nextLine();
            x = text.charAt(0);


        }
    
        sc.close();
    }

    private static void createFlight(String text) throws IOException{
        String[] data = {};
        String outputIdentifier = "";

        data = text.split(" ");
        
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

    }

    public static void readFile(String fname) throws FileNotFoundException{
        String[] aux = {};
        int ex = 0;
        int tur = 0;
        String codigo = "";
        Plane plane;
        Voo voo;


        File f = new File(fname);
        Scanner scf = new Scanner(f);

        while(scf.hasNextLine()){
            String data = scf.nextLine();
            
            
            if(data.charAt(0)==('>')){                                                  // primeira linha
                String aviao = data.replaceAll(">"," ");
                aux = aviao.split(" "); 
                codigo = aux[1];                                                //aux é um array com a info da primeira linha
                
                if(aux.length == 3){                                                    // no caso de não haver Executiva
                       
                    plane = new Plane(aux[2]);
                    voo = new Voo(codigo, plane);

                    if(voos.size()>0){                                                  //se já existir um voo na lista
                        for(int i=0; i<voos.size();i++){
                            if(voos.get(i).getCode().equals(codigo)){                   //se ja existir um voo com o mesmo código vamos subtituir oque esta pelo novo
                                voos.remove(i);
                            }
                        }
                        voos.add(voo);
                    }else{
                        voos.add(voo);                                                  //voo com este codigo ainda não existe
                    }
                    
                }else{

                    plane = new Plane(aux[2], aux[3]);
                    voo = new Voo(codigo, plane);

                    if(voos.size()>0){                                                  //se já existir um voo na lista
                        for(int i=0; i<voos.size();i++){
                            if(voos.get(i).getCode().equals(codigo)){                   //se ja existir um voo com o mesmo código vamos subtituir oque esta pelo novo
                                voos.remove(i);
                            }
                        }
                        voos.add(voo);
                    }else{
                        voos.add(voo);                                                  //voo com este codigo ainda não existe
                    }

                }
                ex = plane.getTotalExecutives();                                        //guarda 2 variaveis com os lugares neste voo
                tur = plane.getTotalTurists();

                System.out.print("Codigo de voo " + voo.getCode() + ". Lugares disponiveis: ");
                if(plane.hasExecutive())
                    System.out.println(ex + " lugares em classe Executiva; " + tur + " lugares em classe Turistica.");
                else{
                    System.out.println(tur + " lugares em classe Turistica.\nClasse executiva nao disponivel neste voo.");
                }

                

            }else{                                                                      //linhas de reservas no ficheiro
                plane = voos.get(voos.size()-1).getPlane();                             // vai bucar a info do ultimo "plane" criado 
             
                if(data.charAt(0) == 'E' && !plane.hasExecutive()){     //se houver reservas em executiva sem o voo ter executiva
                    System.out.println("Nao foi possivel obter lugares para a reserva: " + data);
                }else{
                    aux = data.split(" ");
                    if(data.charAt(0) == 'E'){                  //reserva executiva
                        if(ex - Integer.valueOf(aux[1])<0){     //verificar se há lugares
                            System.out.println("Nao foi possivel obter lugares para a reserva: " + data);   //não há mais lugares
                        }else{
                            ex = ex - Integer.valueOf(aux[1]);  //subtrai lugares reservados
                        }
                    }
                    if(data.charAt(0) == 'T'){                  //reserva turistica
                        if(tur - Integer.valueOf(aux[1])<0){    //verificar se há lugares
                            System.out.println("Nao foi possivel obter lugares para a reserva: " + data);   //não há mais lugares
                        }else{
                            tur = tur - Integer.valueOf(aux[1]);    //subtrai lugares reservados
                        }   
                    }
                }
            }

            

        }     

        scf.close();
    }

}