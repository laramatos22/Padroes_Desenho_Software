package Padroes_Estruturais.Bridge;

/**
 * SmallCar é semelhante a BigBus só que mais leve.
 */

public class SmallCar extends Veiculo {

    public SmallCar (Motor motor) {
        this.pesoKilos = 600;
        this.motor = motor;
    }

    @Override
    public void drive() {
        System.out.print("SmallCar está a andar");
        int ncavalos = motor.go();
        relatarVelocidade(ncavalos);
    } 
    
}
