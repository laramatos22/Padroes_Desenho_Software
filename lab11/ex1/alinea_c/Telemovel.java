package ex1.alinea_c;

public class Telemovel {

    private String processador;
    private double preco;
    private int memoria;
    private int camara;

    public Telemovel(String processador, double preco, int memoria, int camara) {
        this.processador = processador;
        this.preco = preco;
        this.memoria = memoria;
        this.camara = camara;
    }

    public String getProcessador() {return this.processador;}
    public double getPreco() {return this.preco;}
    public double getMemoria() {return this.memoria;}
    public int getCamara() {return this.camara;}
    
}
