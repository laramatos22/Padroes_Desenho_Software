package FactoryMethod;

/** A classe Dog é uma subclasse de Animal.
 * Implementa makeSound e retorna "Woof".
 */

public class Dog extends Animal {
    @Override
    public String makeSound() {
        return "Woof";
    }
}
