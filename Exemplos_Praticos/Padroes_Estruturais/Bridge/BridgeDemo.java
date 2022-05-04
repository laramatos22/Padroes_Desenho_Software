package Padroes_Estruturais.Bridge;

/**
 * A classe BridgeDemo demonstra o padrão Bridge. É criado um veículo BigBus
 * com um implementador SmallMotor. É invocado o método drive() e, em seguida, 
 * é alterado o implementador para BigMotor e é chamado novamente drive().
 * Depois disto, é criado um SmallCar com um implementador SmallMotor.
 * É invocado drive() e, em seguida, altera-se o motor para um BigMotor e mais
 * uma vez drive().
 */

 /**
  * Observar que é possível mudar o implementador (Motor) dinamicamente para cada 
  * veículo. Estas mudanças não afetam o código do cliente em BridgeDemo. 
  * Além disso, apesar de BigBus e SmallCar serem ambos subclasses abstratas de 
  * Veículo, foi possível apontar a referência veículo para um objeto BigBus e um
  * objeto SmallCar e chamar o método drive() à mesma para ambos os tipos de 
  * veículos.
  */

public class BridgeDemo {

    public static void main(String[] args){
        Veiculo v = new BigBus(new SmallMotor());
        v.drive();
        v.setMotor(new BigMotor());
        v.drive();

        v = new SmallCar(new SmallMotor());
        v.drive();
        v.setMotor(new BigMotor());
        v.drive();
    }
    
}
