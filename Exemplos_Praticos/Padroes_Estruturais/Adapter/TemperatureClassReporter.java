package Padroes_Estruturais.Adapter;

/**
 * TemperatureClassReporter é um Adapter. Estende o CelsiusReporter (o
 * adaptado) e implementa TemperatureInfo (interface de destino).
 * Se a temperatura está em Celsius, TemperatureClassReporter utiliza temperaturaC
 * do CelsiusReporter. Os pedidos em Fahrenheit são manipulados 
 * internamente em Celsius.
 */

public class TemperatureClassReporter extends CelciusReporter implements TemperatureInfo {

    private double temperaturaF;

    @Override 
    public double getTemperaturaC() {return temperaturaC;}

    @Override
    public double getTemperaturaF() {return cToF(temperaturaC);}

    @Override
    public void setTemperaturaC (double temperaturaC) {this.temperaturaC = temperaturaC;}

    @Override
    public void setTemperaturaF (double temperaturaF) {this.temperaturaF = temperaturaF;}

    private double fToC(double f) {
        return ((f-32)*5/9);
    }

    private double cToF(double c) {
        return ((c*9/5)+32);
    }


}
