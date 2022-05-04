package Padroes_Estruturais.Decorator;

/**
 * LegDecorator é um ConcreteDecorator.
 * O construtor AnimalDecorator recebe como parâmetro um Animal.
 * O método describe() de AnimalDecorator invoca a referência Animal describe()
 * e em seguida, envia uma emnsagem adicional. Depois, é chamado o método dance(),
 * mostrando que funcionalidades adicionais podem ser adicionadas pelo
 * ConcreteDecorator.
 */

public class LegDecorator extends AnimalDecorator {
    
    public LegDecorator(Animal animal) {super(animal);}

    @Override
    public void describe() {
        animal.describe();
        System.out.println("Tenho pernas");
        dance();
    }

    public void dance() {
        System.out.print("Eu danço");
    }
}
