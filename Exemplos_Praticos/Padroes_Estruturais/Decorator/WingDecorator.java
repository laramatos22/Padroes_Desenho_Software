package Padroes_Estruturais.Decorator;

/**
 * WingDecorator é um ConcreteDecorator, 
 * muito semelhante ao LegDecorator.
 */

public class WingDecorator extends AnimalDecorator {
    
    public WingDecorator(Animal animal) {super(animal);}

    @Override
    public void describe() {
        animal.describe();
        System.out.println("Tenho asas");
        fly();
    }

    public void fly() {
        System.out.print("Eu voo");
    }
}
