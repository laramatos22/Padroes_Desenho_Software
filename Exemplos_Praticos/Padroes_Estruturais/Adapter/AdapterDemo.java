package Padroes_Estruturais.Adapter;

/**
 * A classe AdapterDemo é uma classe Client.
 * Primeiro, é criado um objeto TemperatureClassReporter e faz referência
 * a ele através de uma TemperaturaInfo.
 * Depois, é criado um objeto TemperatureObjectReport e faz referência 
 * a ele através da mesma referência de TemperatureInfo. Ele então 
 * demonstra as chamadas para o objeto Adapter.
 */

public class AdapterDemo {
    
    public static void main(String[] args){
        //Adapter Class
        System.out.println("class adapter test");
        TemperatureInfo tempInfo = new TemperatureClassReporter();
        testTempInfo(tempInfo);

        //Adapter Object
        System.out.println("objeto adapter test");
        tempInfo = new TemperatureObjectReporter();
        testTempInfo(tempInfo);
    }

    public static void testTempInfo(TemperatureInfo tempInfo){
        tempInfo.setTemperaturaC(0);
        System.out.println("temp in C:" + tempInfo.getTemperaturaC());
        System.out.println("temp in F:" + tempInfo.getTemperaturaF());

        tempInfo.setTemperaturaF(85);
        System.out.println("temp in C:" + tempInfo.getTemperaturaC());
        System.out.println("temp in F:" + tempInfo.getTemperaturaF());
    }

}
