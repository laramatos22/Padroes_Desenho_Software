package FactoryMethod;

/** A classe Cat é uma subclasse de Animal.
 * Implementa makeSound() e retorna "Miau".
 */

public class Cat extends Animal {
    @Override
    public String makeSound() {
            return "Miau";
    }
}
