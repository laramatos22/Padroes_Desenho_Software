package Padroes_Estruturais.Bridge;

/**
 * BigBus é uma subclasse de Veiculo.
 * Tem um peso de 3000 kg e o método drive() exibe uma mensagem, invoca o método
 * go() do Motor e em seguida invoca o relatarVelocidade() com a potência do motor 
 * para saber o quão rápido o veículo se está a mover.
 */

public class BigBus extends Veiculo {

    public BigBus (Motor motor) {
        this.pesoKilos = 3000;
        this.motor = motor;
    }

    @Override
    public void drive() {
        System.out.print("BigBus está a andar");
        int ncavalos = motor.go();
        relatarVelocidade(ncavalos);
    } 
}
