//package lab03;
public class Reservation {
    private Tipo Classe;
    private int lugares;
    
    private enum Tipo {
        E,T
    }
    
    public Reservation(String Classe,int lugares ){
        this.Classe = Tipo.valueOf(Classe);
        this.lugares = lugares;
        
    }
    
    public String getTipo(){
        return this.Classe.toString();
    }
    
    public int getLugares(){
        return this.lugares;
    }
    
}
