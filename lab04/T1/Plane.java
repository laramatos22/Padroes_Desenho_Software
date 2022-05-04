//package lab03;

import java.util.stream.Stream;

import java.util.Arrays;

public class Plane {
    
    private boolean e = true;
    
    private final String tur;
    private final String exec;

    private int[][] turistas;
    private int[][] empresariais;
    private final int[] tur_size;
    private final int[] em_size;
    private int res = 1;
    
    
   
	
    public Plane(String exec, String tur) {
        
        this.tur_size = Stream.of(tur.split("x")).mapToInt(Integer::parseInt).toArray();
        this.em_size = Stream.of(exec.split("x")).mapToInt(Integer::parseInt).toArray();
        
        this.turistas = new int[this.tur_size[1]][this.tur_size[0]];
        this.empresariais = new int[this.em_size[1]][this.em_size[0]];

        this.tur = tur;
        this.exec = exec;
       
    }
    
    public Plane(String tur){
        this.tur_size = Stream.of(tur.split("x")).mapToInt(Integer::parseInt).toArray();
        this.em_size = new int[] {1,1};
        this.turistas = new int[this.tur_size[1]][this.tur_size[0]];
        this.empresariais = new int[this.em_size[1]][this.em_size[0]];
        this.tur = tur;
        this.exec = "0x0";
        this.e = false;
    
    }

    public int getTotalTurists(){
        String[] conta = {};
        conta = tur.split("x");
        return Integer.valueOf(conta[0])*Integer.valueOf(conta[1]);  
    }

    public int getTotalExecutives(){
        String[] conta = {};
        conta = exec.split("x");
        return Integer.valueOf(conta[0])*Integer.valueOf(conta[1]);  
    }

    
    public String getTuristas(){
        StringBuilder sb = new StringBuilder();
        
        for(int[] i : this.turistas){
            
            for(int j : i){
                sb.append(String.valueOf(j)+" ");
            }
            sb.append("\n");
         
        }
        return sb.toString();
    }
    
    public String getEmpresariais(){
        StringBuilder sb = new StringBuilder();
        int pointer = 0;
        String abc = " ABCDEFGHIJKLMNOPRSTUVXWYZ";
        for(int[] i : this.empresariais){
           sb.append(String.valueOf(abc.charAt(pointer))+" ");
            for(int j : i){
                sb.append(String.valueOf(j)+" ");
            }
            sb.append("\n");
            pointer++;
        }
        for(int i=0;i<Math.abs(this.em_size[1]-this.tur_size[1]);i++){
            char[] temp = new char[this.em_size[0]*2];
            Arrays.fill(temp,' ');
            sb.append(String.valueOf(abc.charAt(pointer))+" ");
            sb.append(new String(temp)+"\n");
            pointer++;
        }
        return sb.toString();
    }
    
    public String getMap(){
        
        String[] emp_arr = this.getEmpresariais().split("\n");
        String[] tur_arr = this.getTuristas().split("\n");
        
        StringBuilder sb = new StringBuilder();
        
        System.out.println(String.valueOf(emp_arr.length));
        System.out.println(String.valueOf(tur_arr.length));
        
        for(int i =0;i<Math.max(emp_arr.length, tur_arr.length);i++){
            sb.append(emp_arr[i]+tur_arr[i]+"\n");
        }
        return sb.toString();
    }
        
    
    
    
    public boolean addReservation(Reservation r){
        
        String tipo = r.getTipo();
        int nlug = r.getLugares();
        int[][] lugares;
        if(tipo.equals("E") && this.e){
            lugares = Arrays.copyOf(this.empresariais,this.empresariais.length);
            for(int i=0;i<this.em_size[0];i++){
                for(int j=0;j<this.em_size[1];j++){
                    if(this.empresariais[j][i] == 0){
                        this.empresariais[j][i] = this.res;
                        nlug--;
                        if(nlug == 0){
                            return true;
                        }
                    }
     
                }
            }
            this.empresariais = Arrays.copyOf(lugares,this.empresariais.length);
        }
        
        if(tipo.equals("T")){
            lugares = Arrays.copyOf(this.turistas,this.turistas.length);
            for(int i=0;i<this.tur_size[0];i++){
                for(int j=0;j<this.tur_size[1];j++){
                    if(this.turistas[j][i] == 0){
                        this.turistas[j][i] = this.res;
                        nlug--;
                        if(nlug == 0){
                            return true;
                        }
                    }
     
                }
            }
            this.turistas =  Arrays.copyOf(lugares,this.turistas.length);
        }
        
        return false;
    }

    public boolean hasExecutive(){
        return e;
    }

    public String toString(){
        String s = "";
        
        s = this.exec + " " +  this.tur;
        
            
        return s;
    }
    
    
}


