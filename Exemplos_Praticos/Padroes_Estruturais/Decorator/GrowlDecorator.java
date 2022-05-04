package Padroes_Estruturais.Decorator;

/**
 * GrowlDecorator é outro ConcreteDecorator.
 */

public class GrowlDecorator extends AnimalDecorator {
    
    public GrowlDecorator(Animal animal) {super(animal);}

    @Override
    public void describe() {
        animal.describe();
        System.out.println("Tenho asas");
        growl();
    }

    public void growl() {
        System.out.print("Grrr");
    }
}
