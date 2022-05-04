package ex2;

public class Reserva {
    private String classe;
    private int nlug; //numero de lugares
    private int id;

    public Reserva(String classe, int nlug){
        this.classe=classe;
        this.nlug=nlug;
    }
    public Reserva(String classe, int nlug, int id){
        this.classe=classe;
        this.nlug=nlug;
        this.id=id;
    }
    public String getClasse(){
        return classe;
    }
    public int getNlug(){
        return nlug;
    }
    public int getID(){
        return id;
    }
    public void setClasse(String classe){
        this.classe=classe;
    }
    public void setNlug(int nlug){
        this.nlug=nlug;
    }
    public void setID(int id){
        this.id=id;
    }

    public String toID(){
        return String.valueOf(id);
    }
    @Override
    public String toString(){
        return classe +" "+ String.valueOf(nlug);
    }
}
