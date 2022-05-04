package Padroes_Estruturais.Adapter;

/**
 * TemperatureInfo é a interface que será implementada pelo Adapter.
 * Ela define as ações que o Adapter irá realizar.
 */

public interface TemperatureInfo {
    public double getTemperaturaF();
    public void setTemperaturaF (double temperaturaF);
    public double getTemperaturaC();
    public void setTemperaturaC (double temperaturaC);
}
