package Padroes_Estruturais.Decorator;

/**
 * LivingAnimal implementa Animal e é ConcreteComponent.
 * O método describe() exibe uma mensagem indicando que é animal.
 */

public class LivingAnimal implements Animal {
    @Override
    public void describe() {
        System.out.println("Sou um animal");
    }
}
