package Padroes_Estruturais.Bridge;

/**
 * Supondo que temos uma classe Veículo.
 * Podemos extrair a implementação do motor de uma classe Motor.
 * Podemos referenciar este mecanismo no nosso veículo através do campo motor.
 */

 /**
  * A classe Veiculo vai ser abstrata.
  * Subclasses de Veiculo precisam de implementar o método drive().
  * Observar que a referência Motor pode ser alterada a partir do método setMotor().
  */

public abstract class Veiculo {

    Motor motor;
    int pesoKilos;
    public abstract void drive();
    public void setMotor (Motor motor) {this.motor = motor;}

    public void relatarVelocidade (int ncavalos) {
        int racio = pesoKilos / ncavalos;

        if (racio < 3)
            System.out.println("Veículo vai a exceder a velocidade");
        else if ((racio >= 3) && (racio < 8))
            System.out.println("Veículo está numa velocidade média");
        else 
            System.out.println("Veículo vai a uma velocidade baixa");
    }
}
