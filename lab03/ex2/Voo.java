package ex2;

import java.util.LinkedList;

public class Voo {
    private String id;
    private int executiva;
    private int execOcupados=0;
    private int turistica;
    private int turOcupados=0;
    private LinkedList<Reserva> reservas;

    //----- Varios construtores consoante o que for preciso na Gestor
    public Voo(String id){
        this.id=id;
        
    }
    public Voo(String id, String exec, String tur){
        this.id=id;
        executiva=multiplicar(exec);
        turistica=multiplicar(tur);
    }
    public Voo(String id, String tur){
        this.id=id;
        executiva=0;
        turistica=multiplicar(tur);
    }

    public Voo(String id, int exec, int tur){
        this.id=id;
        executiva=exec;
        turistica=tur;
    }

    //------- Funcoes  ---------
    public void addReserva(Reserva reserva){
        String classe = reserva.getClasse();
        boolean adding;
        if(classe.equals("E"))adding = addExecutiva(reserva);
        else adding = addTuristica(reserva);
        if(!adding){
            System.out.println("Não foi possivel obter lugares para a reserva: "+reserva.toString());
        }
        reservas.getLast().setID(reservas.size());
    }
    private boolean addExecutiva(Reserva reserva){
        if(executiva-execOcupados>=reserva.getNlug()){
            execOcupados+= reserva.getNlug();
            reservas.add(reserva);
            return true;
        }
        return false;
    }
    private boolean addTuristica(Reserva reserva){
        if(turistica-turOcupados>=reserva.getNlug()){
            turOcupados+= reserva.getNlug();
            reservas.add(reserva);
            return true;
        }
        return false;
    }

    public void printReservas(){
        int nlug = executiva+turistica;
        int cont = 0;
        for(int k=0; k<reservas.size(); k++){
            for(int c=0; c<reservas.get(k).getNlug(); c++){
                System.out.print(reservas.get(k).toID()+" ");
                cont++;
            }
        }
        for(int i=cont; i<nlug; i++){
            System.out.println("0 ");
        }
    }

    public void cancelaR(int code){
        reservas.remove(code);
        //Como code é o id = numero sequencial
        //ou seja, a primeira reserva vai ter o numero 0, a segunda o 1, etc...
    }

    //------- Funcoes auxiliares ---------
    private int multiplicar(String str){ //String do tipo AxB
        char[] ch = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            ch[i] = str.charAt(i);
        }
        return Character.getNumericValue(ch[0]) * Character.getNumericValue(ch[2]); //multiplicar A * B
    }
    

    //---------- Gets e Sets ----------------
    public String getID(){
        return id;
    }
    public int getExec(){
        return executiva;
    }
    public int getTur(){
        return turistica;
    }
    public void setID(String id){
        this.id=id;
    }
    public void setExec(int i){
        executiva=i;
    }
    public void setTur(int i){
        turistica=i;
    }

    @Override
    public String toString(){
        if(executiva==0) return "Código de voo "+id+". Lugares disponíveis: "+turistica+" em classe Turística.\n Classe Executiva não disponível neste voo.";
        return "Código de voo "+id+". Lugares disponíveis: "+ executiva+" em classe Executiva;"+turistica+" lugares em classe Turística.";
    }
}
