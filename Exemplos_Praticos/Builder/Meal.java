package Builder;

/**
 * Construção de diferentes tipode de refeição de um restaurante.
 * A classe Meal será o nosso Produto, que representa os itens numa 
 * refeição - prato, bebida, entrada.
 */

public class Meal {
    
    private String prato, bebida, entrada;

    public String getBebida() {return bebida;}
    public void setBebida (String bebida) {this.bebida = bebida;}

    public String getPrato() {return prato;}
    public void setPrato(String prato) {this.prato = prato;}

    public String getEntrada() {return entrada;}
    public void setEntrada(String entrada) {this.entrada = entrada;}
}
