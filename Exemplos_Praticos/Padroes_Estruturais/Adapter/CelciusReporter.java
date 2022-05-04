package Padroes_Estruturais.Adapter;

/**
 * A classe CelkciusReporter armazena um valor da temperatura em Celcius.
 */

public class CelciusReporter {

    double temperaturaC;
    public CelciusReporter() {}
    public double getTemperatura() {return temperaturaC;}
    public void setTemperatura (double temperaturaC) {this.temperaturaC = temperaturaC;}
    
}
